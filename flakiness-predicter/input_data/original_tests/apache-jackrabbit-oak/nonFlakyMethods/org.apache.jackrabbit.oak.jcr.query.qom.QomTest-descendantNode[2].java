@Test public void descendantNode() throws RepositoryException {
  DescendantNode d=f.descendantNode("selectorName","path");
  assertEquals("selectorName",d.getSelectorName());
  assertEquals("path",d.getAncestorPath());
  assertEquals("ISDESCENDANTNODE([selectorName], [path])",d.toString());
  assertEquals("ISDESCENDANTNODE([p])",f.descendantNode(null,"p").toString());
}
