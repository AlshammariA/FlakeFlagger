@Test public void testMaxCount() throws Exception {
  final long count=Long.MAX_VALUE;
  final long countjr2=-1;
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setSortOrder("profile/@weight",QueryBuilder.Direction.ASCENDING);
      builder.setLimit(0,countjr2);
    }
  }
);
  Iterator<Authorizable> expected=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setSortOrder("profile/@weight",QueryBuilder.Direction.ASCENDING);
      builder.setLimit(0,count);
    }
  }
);
  assertSame(expected,result,count);
  assertFalse(result.hasNext());
}
