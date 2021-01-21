@Test public void testScopeWithOffset() throws RepositoryException {
  final int offset=5;
  final int count=10000;
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setScope("vertebrates",false);
      builder.setSortOrder("profile/@weight",QueryBuilder.Direction.ASCENDING);
      builder.setLimit(offset,count);
    }
  }
);
  Iterator<Authorizable> expected=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setScope("vertebrates",false);
      builder.setSortOrder("profile/@weight",QueryBuilder.Direction.ASCENDING);
    }
  }
);
  skip(expected,offset);
  assertSame(expected,result,count);
  assertFalse(result.hasNext());
}
