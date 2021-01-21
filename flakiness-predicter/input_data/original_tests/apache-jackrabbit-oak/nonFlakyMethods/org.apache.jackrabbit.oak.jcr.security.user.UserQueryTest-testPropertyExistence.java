@Test public void testPropertyExistence() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.exists("@poisonous"));
    }
  }
);
  Iterator<User> expected=Iterators.filter(users.iterator(),new Predicate<User>(){
    public boolean apply(    User user){
      try {
        Value[] poisonous=user.getProperty("poisonous");
        return poisonous != null && poisonous.length == 1;
      }
 catch (      RepositoryException e) {
        fail(e.getMessage());
      }
      return false;
    }
  }
);
  assertTrue(result.hasNext());
  assertSameElements(result,expected);
}
