@Test public void nodeLocalName() throws RepositoryException {
  NodeLocalName n=f.nodeLocalName("selectorName");
  assertEquals("selectorName",n.getSelectorName());
  assertEquals("LOCALNAME([selectorName])",n.toString());
  assertEquals("LOCALNAME()",f.nodeLocalName(null).toString());
}
