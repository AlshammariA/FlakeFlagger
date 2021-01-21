@Test public void testDirectScope() throws RepositoryException {
  Group[] groups=new Group[]{mammals,vertebrates,apes};
  for (  final Group g : groups) {
    Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
      public <T>void build(      QueryBuilder<T> builder){
        try {
          builder.setScope(g.getID(),true);
        }
 catch (        RepositoryException e) {
          fail(e.getMessage());
        }
      }
    }
);
    Iterator<Authorizable> members=g.getDeclaredMembers();
    assertSameElements(result,members);
  }
}
