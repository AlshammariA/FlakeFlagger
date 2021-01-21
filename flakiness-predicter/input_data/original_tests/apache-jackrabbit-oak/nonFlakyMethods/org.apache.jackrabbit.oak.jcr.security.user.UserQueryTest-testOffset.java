@Test public void testOffset() throws RepositoryException {
  long[] offsets={2,0,3,0,100000};
  long[] counts={4,4,0,100000,100000};
  for (int k=0; k < offsets.length; k++) {
    final long offset=offsets[k];
    final long count=counts[k];
    Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
      public <T>void build(      QueryBuilder<T> builder){
        builder.setSortOrder("profile/@weight",QueryBuilder.Direction.ASCENDING);
        builder.setLimit(offset,count);
      }
    }
);
    Iterator<Authorizable> expected=userMgr.findAuthorizables(new Query(){
      public <T>void build(      QueryBuilder<T> builder){
        builder.setSortOrder("profile/@weight",QueryBuilder.Direction.ASCENDING);
      }
    }
);
    skip(expected,offset);
    assertSame(expected,result,count);
    assertFalse(result.hasNext());
  }
}
