/** 
 * @since oak
 */
@Test public void testVersionableChildNode2() throws Exception {
  Node testNode=superuser.getNode(path).addNode("n1").addNode("n2").addNode("n3").addNode("jcr:content");
  testNode.addMixin("mix:versionable");
  superuser.save();
  testNode.remove();
  testNode=superuser.getNode(path).getNode("n1").getNode("n2").getNode("n3").addNode("jcr:content");
  testNode.addMixin("mix:versionable");
  superuser.save();
  assertTrue(testNode.isNodeType("mix:versionable"));
  VersionHistory vh=testNode.getVersionHistory();
  Property versionablePath=vh.getProperty(superuser.getWorkspace().getName());
  assertEquals(testNode.getPath(),versionablePath.getString());
}
