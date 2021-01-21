@Test public void testSortOrder1() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.exists("@color"));
      builder.setSortOrder("@color",QueryBuilder.Direction.DESCENDING);
    }
  }
);
  assertTrue(result.hasNext());
  String prev=null;
  while (result.hasNext()) {
    Authorizable authorizable=result.next();
    Value[] color=authorizable.getProperty("color");
    assertNotNull(color);
    assertEquals(1,color.length);
    assertTrue(prev == null || prev.compareToIgnoreCase(color[0].getString()) >= 0);
    prev=color[0].getString();
  }
}
