@Test public void testSelector() throws RepositoryException {
  List<Class<? extends Authorizable>> selectors=new ArrayList<Class<? extends Authorizable>>();
  selectors.add(Authorizable.class);
  selectors.add(Group.class);
  selectors.add(User.class);
  for (  final Class<? extends Authorizable> s : selectors) {
    Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
      public <T>void build(      QueryBuilder<T> builder){
        builder.setSelector(s);
      }
    }
);
    if (User.class.isAssignableFrom(s)) {
      assertSameElements(result,users.iterator());
    }
 else     if (Group.class.isAssignableFrom(s)) {
      assertSameElements(result,groups.iterator());
    }
 else {
      assertSameElements(result,authorizables.iterator());
    }
  }
}
