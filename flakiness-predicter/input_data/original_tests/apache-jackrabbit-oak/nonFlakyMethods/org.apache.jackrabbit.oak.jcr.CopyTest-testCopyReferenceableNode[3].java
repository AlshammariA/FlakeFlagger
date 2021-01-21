@Test public void testCopyReferenceableNode() throws Exception {
  Session session=getAdminSession();
  Node toCopy=session.getNode(TEST_PATH + "/source/node");
  toCopy.addMixin(JcrConstants.MIX_REFERENCEABLE);
  session.save();
  session.getWorkspace().copy(TEST_PATH + "/source/node",TEST_PATH + "/target/copied");
  assertTrue(testNode.hasNode("source/node"));
  assertTrue(testNode.hasNode("target/copied"));
  Node copy=testNode.getNode("target/copied");
  assertTrue(copy.isNodeType(JcrConstants.MIX_REFERENCEABLE));
  assertFalse(copy.getUUID().equals(testNode.getNode("source/node").getUUID()));
}
