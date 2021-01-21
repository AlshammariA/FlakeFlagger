@Test public void testFindGroupsInGroup() throws RepositoryException {
  Group[] groups=new Group[]{mammals,vertebrates,apes};
  for (  final Group g : groups) {
    Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
      public <T>void build(      QueryBuilder<T> builder){
        try {
          builder.setSelector(Group.class);
          builder.setScope(g.getID(),true);
        }
 catch (        RepositoryException e) {
          fail(e.getMessage());
        }
      }
    }
);
    Iterator<Authorizable> members=g.getDeclaredMembers();
    Iterator<Authorizable> users=Iterators.filter(members,new Predicate<Authorizable>(){
      public boolean apply(      Authorizable authorizable){
        return authorizable.isGroup();
      }
    }
);
    assertSameElements(result,users);
  }
}
