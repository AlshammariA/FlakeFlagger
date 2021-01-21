@Test public void childNode() throws RepositoryException {
  ChildNode cn=f.childNode("selectorName","parentPath");
  assertEquals("selectorName",cn.getSelectorName());
  assertEquals("parentPath",cn.getParentPath());
  assertEquals("ISCHILDNODE([selectorName], [parentPath])",cn.toString());
  assertEquals("ISCHILDNODE([p])",f.childNode(null,"p").toString());
}
