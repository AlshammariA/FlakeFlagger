@Test public void testCondition1() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.and(builder.eq("profile/@cute",vf.createValue(true)),builder.not(builder.eq("@color",vf.createValue("black")))));
    }
  }
);
  Iterator<User> expected=Iterators.filter(users.iterator(),new Predicate<User>(){
    public boolean apply(    User user){
      try {
        Value[] cute=user.getProperty("profile/cute");
        Value[] black=user.getProperty("color");
        return cute != null && cute.length == 1 && cute[0].getBoolean() && !(black != null && black.length == 1 && black[0].getString().equals("black"));
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
