@Test public void sameNode() throws RepositoryException {
  SameNode s=f.sameNode("selectorName","path");
  assertEquals("selectorName",s.getSelectorName());
  assertEquals("path",s.getPath());
  assertEquals("ISSAMENODE([selectorName], [path])",s.toString());
  assertEquals("ISSAMENODE([path])",f.sameNode(null,"path").toString());
  assertEquals("ISSAMENODE([s], [path])",f.sameNode("s","path").toString());
}
