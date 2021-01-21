/** 
 * @since oak
 */
@Test public void testVersionableChildNode() throws Exception {
  Node testNode=superuser.getNode(path).addNode("n1").addNode("n2").addNode("n3").addNode("jcr:content");
  superuser.save();
  testNode.addMixin("mix:versionable");
  superuser.save();
  assertTrue(testNode.isNodeType("mix:versionable"));
  VersionHistory vh=testNode.getVersionHistory();
  Property versionablePath=vh.getProperty(superuser.getWorkspace().getName());
  assertEquals(testNode.getPath(),versionablePath.getString());
}
