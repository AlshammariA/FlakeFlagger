@Test public void testCopyVersionableNode() throws Exception {
  Session session=getAdminSession();
  Node toCopy=session.getNode(TEST_PATH + "/source/node");
  toCopy.addMixin(JcrConstants.MIX_VERSIONABLE);
  session.save();
  session.getWorkspace().copy(TEST_PATH + "/source/node",TEST_PATH + "/target/copied");
  assertTrue(testNode.hasNode("source/node"));
  assertTrue(testNode.hasNode("target/copied"));
  Node copy=testNode.getNode("target/copied");
  assertTrue(copy.isNodeType(JcrConstants.MIX_VERSIONABLE));
  assertFalse(copy.getVersionHistory().isSame(toCopy.getVersionHistory()));
}
