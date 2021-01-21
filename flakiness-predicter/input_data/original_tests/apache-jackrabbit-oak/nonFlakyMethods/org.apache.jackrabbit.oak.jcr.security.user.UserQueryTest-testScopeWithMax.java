@Test public void testScopeWithMax() throws RepositoryException {
  final int offset=0;
  final int count=22;
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
  assertSameElements(expected,result);
  assertFalse(result.hasNext());
}
