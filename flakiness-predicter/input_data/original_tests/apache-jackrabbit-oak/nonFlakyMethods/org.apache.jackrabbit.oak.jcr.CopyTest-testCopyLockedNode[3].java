@Test public void testCopyLockedNode() throws Exception {
  Session session=getAdminSession();
  Node toCopy=session.getNode(TEST_PATH + "/source/node");
  toCopy.addMixin(JcrConstants.MIX_LOCKABLE);
  session.save();
  session.getWorkspace().getLockManager().lock(toCopy.getPath(),true,true,Long.MAX_VALUE,"my");
  assertTrue(toCopy.isLocked());
  assertTrue(toCopy.hasProperty(JcrConstants.JCR_LOCKISDEEP));
  assertTrue(toCopy.hasProperty(JcrConstants.JCR_LOCKOWNER));
  session.getWorkspace().copy(TEST_PATH + "/source/node",TEST_PATH + "/target/copied");
  assertTrue(testNode.hasNode("source/node"));
  assertTrue(testNode.hasNode("target/copied"));
  Node copy=testNode.getNode("target/copied");
  assertTrue(copy.isNodeType(JcrConstants.MIX_LOCKABLE));
  assertFalse(copy.isLocked());
  assertFalse(copy.hasProperty(JcrConstants.JCR_LOCKISDEEP));
  assertFalse(copy.hasProperty(JcrConstants.JCR_LOCKOWNER));
}
