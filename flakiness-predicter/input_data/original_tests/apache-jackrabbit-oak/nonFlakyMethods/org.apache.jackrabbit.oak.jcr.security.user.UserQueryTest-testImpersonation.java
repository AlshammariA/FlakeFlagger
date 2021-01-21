@Test public void testImpersonation() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.impersonates("jackrabbit"));
    }
  }
);
  Iterator<User> expected=Iterators.singletonIterator(elephant);
  assertTrue(result.hasNext());
  assertSameElements(expected,result);
}
