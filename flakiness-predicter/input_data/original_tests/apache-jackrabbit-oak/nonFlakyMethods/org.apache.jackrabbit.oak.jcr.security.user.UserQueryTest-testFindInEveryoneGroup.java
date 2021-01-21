@Test public void testFindInEveryoneGroup() throws RepositoryException {
  Authorizable everyone=userMgr.getAuthorizable(EveryonePrincipal.NAME);
  boolean doRemove=false;
  try {
    if (everyone == null) {
      everyone=userMgr.createGroup(EveryonePrincipal.NAME);
      superuser.save();
      doRemove=true;
    }
    Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
      public <T>void build(      QueryBuilder<T> builder){
        builder.setScope(EveryonePrincipal.NAME,true);
      }
    }
);
    Iterator<Authorizable> members=((Group)everyone).getDeclaredMembers();
    assertSameElements(result,members);
  }
  finally {
    if (doRemove) {
      everyone.remove();
      superuser.save();
    }
  }
}
