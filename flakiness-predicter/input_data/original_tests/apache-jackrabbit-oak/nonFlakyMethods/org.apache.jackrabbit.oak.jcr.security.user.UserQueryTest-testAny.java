@Test public void testAny() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
    }
  }
);
  assertSameElements(result,authorizables.iterator());
}
