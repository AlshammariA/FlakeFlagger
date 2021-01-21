@Test public void testContains1() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.contains(".","gold"));
    }
  }
);
  Iterator<User> expected=Iterators.singletonIterator(goldenToad);
  assertTrue(result.hasNext());
  assertSameElements(result,expected);
}
