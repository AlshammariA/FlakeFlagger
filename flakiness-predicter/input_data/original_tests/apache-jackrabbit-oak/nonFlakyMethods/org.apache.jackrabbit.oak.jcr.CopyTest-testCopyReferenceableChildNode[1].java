@Test public void testCopyReferenceableChildNode() throws Exception {
  Session session=getAdminSession();
  session.getNode(TEST_PATH + "/source/node").addNode("child").addMixin(JcrConstants.MIX_REFERENCEABLE);
  session.save();
  session.getWorkspace().copy(TEST_PATH + "/source/node",TEST_PATH + "/target/copied");
  assertTrue(testNode.hasNode("source/node"));
  assertTrue(testNode.hasNode("target/copied"));
  Node childCopy=testNode.getNode("target/copied/child");
  assertTrue(childCopy.isNodeType(JcrConstants.MIX_REFERENCEABLE));
  assertFalse(childCopy.getUUID().equals(testNode.getNode("source/node/child").getUUID()));
}
