@Test public void testCondition2() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.or(builder.eq("profile/@food",vf.createValue("mice")),builder.eq("profile/@food",vf.createValue("nectar"))));
    }
  }
);
  Iterator<User> expected=Iterators.filter(users.iterator(),new Predicate<User>(){
    public boolean apply(    User user){
      try {
        Value[] food=user.getProperty("profile/food");
        return food != null && food.length == 1 && (food[0].getString().equals("mice") || food[0].getString().equals("nectar"));
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
