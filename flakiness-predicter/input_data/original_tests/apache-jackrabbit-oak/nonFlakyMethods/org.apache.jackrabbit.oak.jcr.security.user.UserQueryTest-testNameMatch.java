@Test public void testNameMatch() throws RepositoryException {
  Iterator<Authorizable> result=userMgr.findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.nameMatches("a%"));
    }
  }
);
  Iterator<Authorizable> expected=Iterators.filter(authorizables.iterator(),new Predicate<Authorizable>(){
    public boolean apply(    Authorizable authorizable){
      try {
        String name=authorizable.getID();
        Principal principal=authorizable.getPrincipal();
        return name.startsWith("a") || principal != null && principal.getName().startsWith("a");
      }
 catch (      RepositoryException e) {
        fail(e.getMessage());
      }
      return false;
    }
  }
);
  assertTrue(result.hasNext());
  assertSameElements(result,expected);
}
