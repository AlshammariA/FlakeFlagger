@Test public void testSortOrder2() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.exists("profile/@weight"));
      builder.setSortOrder("profile/@weight",QueryBuilder.Direction.ASCENDING,true);
    }
  }
);
  assertTrue(result.hasNext());
  double prev=Double.MIN_VALUE;
  while (result.hasNext()) {
    Authorizable authorizable=result.next();
    Value[] weight=authorizable.getProperty("profile/weight");
    assertNotNull(weight);
    assertEquals(1,weight.length);
    assertTrue(prev <= weight[0].getDouble());
    prev=weight[0].getDouble();
  }
}
