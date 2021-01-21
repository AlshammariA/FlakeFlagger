@Test public void nodeName() throws RepositoryException {
  NodeName n=f.nodeName("selectorName");
  assertEquals("selectorName",n.getSelectorName());
  assertEquals("NAME([selectorName])",n.toString());
  assertEquals("NAME()",f.nodeName(null).toString());
}
