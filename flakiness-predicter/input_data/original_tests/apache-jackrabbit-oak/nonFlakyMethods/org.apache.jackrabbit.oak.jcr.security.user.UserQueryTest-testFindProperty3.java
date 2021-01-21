@Test public void testFindProperty3() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.eq("@numberOfLegs",vf.createValue(8)));
    }
  }
);
  Iterator<User> expected=Iterators.filter(users.iterator(),new Predicate<User>(){
    public boolean apply(    User user){
      try {
        Value[] numberOfLegs=user.getProperty("numberOfLegs");
        return numberOfLegs != null && numberOfLegs.length == 1 && numberOfLegs[0].getLong() == 8;
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
