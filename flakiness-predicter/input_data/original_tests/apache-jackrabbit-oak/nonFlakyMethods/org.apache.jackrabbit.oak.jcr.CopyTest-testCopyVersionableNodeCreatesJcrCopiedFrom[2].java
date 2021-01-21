@Test public void testCopyVersionableNodeCreatesJcrCopiedFrom() throws Exception {
  Session session=getAdminSession();
  Node toCopy=session.getNode(TEST_PATH + "/source/node");
  toCopy.addMixin(JcrConstants.MIX_VERSIONABLE);
  session.save();
  Version baseV=toCopy.getBaseVersion();
  session.getWorkspace().copy(TEST_PATH + "/source/node",TEST_PATH + "/target/copied");
  Node copy=testNode.getNode("target/copied");
  VersionHistory copiedVh=copy.getVersionHistory();
  assertTrue(copiedVh.hasProperty(VersionConstants.JCR_COPIED_FROM));
  Property prop=copiedVh.getProperty(VersionConstants.JCR_COPIED_FROM);
  assertEquals(PropertyType.WEAKREFERENCE,prop.getType());
  Node copiedFrom=prop.getNode();
  assertTrue(baseV.isSame(copiedFrom));
}
