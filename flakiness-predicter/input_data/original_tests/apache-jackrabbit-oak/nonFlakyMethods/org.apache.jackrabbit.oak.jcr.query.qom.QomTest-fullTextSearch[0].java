@Test public void fullTextSearch() throws RepositoryException {
  Literal l=f.literal(vf.createValue(1));
  FullTextSearch x=f.fullTextSearch("selectorName","propertyName",l);
  assertEquals("selectorName",x.getSelectorName());
  assertEquals("propertyName",x.getPropertyName());
  assertEquals(l,x.getFullTextSearchExpression());
  assertEquals("CONTAINS([selectorName].[propertyName], 1)",x.toString());
  assertEquals("CONTAINS([p], null)",f.fullTextSearch(null,"p",null).toString());
  assertEquals("CONTAINS([s].[p], null)",f.fullTextSearch("s","p",null).toString());
  assertEquals("CONTAINS([s].*, null)",f.fullTextSearch("s",null,null).toString());
  assertEquals("CONTAINS(*, null)",f.fullTextSearch(null,null,null).toString());
}
