/** 
 * Test SNS 1-based indexed path. JCR 2.0, Chapter 22.2: <em> A name in a content repository path that does not explicitly specify an index implies an index of 1. For example, /a/b/c is equivalent to /a[1]/b[1]/c[1]. </em>
 * @throws RepositoryException
 */
@Test public void getNodeSNS() throws RepositoryException {
  Node node=getNode("/foo[1]");
  assertNotNull(node);
  assertEquals("foo",node.getName());
  assertEquals("/foo",node.getPath());
  node.addNode("bar");
  Node bar=getNode("/foo[1]/bar[1]");
  assertEquals("/foo/bar",bar.getPath());
  try {
    getNode("/foo[1]/bar[2]");
    fail("retrieving wrong SNS index should throw PathNotFoundException");
  }
 catch (  PathNotFoundException e) {
  }
  try {
    getProperty("/foo[1]/bar[2]/jcr:primaryType");
    fail("retrieving wrong SNS index should throw PathNotFoundException");
  }
 catch (  PathNotFoundException e) {
  }
  assertTrue(getAdminSession().nodeExists("/foo[1]/bar[1]"));
  assertTrue(node.hasNode("bar[1]"));
  assertTrue(node.hasProperty("bar[1]/jcr:primaryType"));
  assertTrue(getAdminSession().propertyExists("/foo[1]/bar[1]/jcr:primaryType"));
  assertFalse(getAdminSession().nodeExists("/foo[1]/bar[2]"));
  assertFalse(node.hasNode("bar[2]"));
  assertFalse(node.hasProperty("bar[2]/jcr:primaryType"));
  assertFalse(getAdminSession().propertyExists("/foo[1]/bar[2]/jcr:primaryType"));
}
