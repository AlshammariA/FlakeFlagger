@Test public void testIndirectScope() throws RepositoryException {
  Group[] groups=new Group[]{mammals,vertebrates,apes};
  for (  final Group g : groups) {
    Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
      public <T>void build(      QueryBuilder<T> builder){
        try {
          builder.setScope(g.getID(),false);
        }
 catch (        RepositoryException e) {
          fail(e.getMessage());
        }
      }
    }
);
    Iterator<Authorizable> members=g.getMembers();
    assertSameElements(result,members);
  }
}
