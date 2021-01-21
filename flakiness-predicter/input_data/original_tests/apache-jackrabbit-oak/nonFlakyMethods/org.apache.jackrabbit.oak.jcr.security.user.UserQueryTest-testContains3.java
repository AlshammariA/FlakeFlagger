@Test public void testContains3() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.contains("profile/.","grass"));
    }
  }
);
  Iterator<User> expected=Iterators.singletonIterator(kangaroo);
  assertTrue(result.hasNext());
  assertSameElements(result,expected);
}
