@Test public void selector() throws RepositoryException {
  Selector s=f.selector("nodeTypeName","selectorName");
  assertEquals("nodeTypeName",s.getNodeTypeName());
  assertEquals("selectorName",s.getSelectorName());
  assertEquals("[nodeTypeName] AS [selectorName]",s.toString());
  assertEquals("[n]",f.selector("n",null).toString());
}
