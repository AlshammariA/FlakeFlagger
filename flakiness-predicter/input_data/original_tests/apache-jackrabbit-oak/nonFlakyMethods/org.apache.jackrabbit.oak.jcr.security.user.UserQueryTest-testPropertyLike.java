@Test public void testPropertyLike() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.like("profile/@food","m%"));
    }
  }
);
  Iterator<User> expected=Iterators.filter(users.iterator(),new Predicate<User>(){
    public boolean apply(    User user){
      try {
        Value[] food=user.getProperty("profile/food");
        if (food == null || food.length != 1) {
          return false;
        }
 else {
          String value=food[0].getString();
          return value.startsWith("m");
        }
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
