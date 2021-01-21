@Test public void testCopyVersionableNodeClearsVersions() throws Exception {
  Session session=getAdminSession();
  Node toCopy=session.getNode(TEST_PATH + "/source/node");
  toCopy.addMixin(JcrConstants.MIX_VERSIONABLE);
  session.save();
  Version v1=toCopy.checkin();
  toCopy.checkout();
  Version v2=toCopy.checkin();
  toCopy.checkout();
  session.getWorkspace().copy(TEST_PATH + "/source/node",TEST_PATH + "/target/copied");
  Node copy=testNode.getNode("target/copied");
  VersionHistory vh=copy.getVersionHistory();
  Version rootV=vh.getRootVersion();
  assertEquals(0,rootV.getSuccessors().length);
  VersionIterator vItr=vh.getAllVersions();
  while (vItr.hasNext()) {
    if (!rootV.isSame(vItr.nextVersion())) {
      fail("Unexpected version in version history of copied node.");
    }
  }
  try {
    vh.getVersion(v1.getName());
    fail("Unexpected version in version history of copied node.");
  }
 catch (  VersionException e) {
  }
  try {
    vh.getVersion(v2.getName());
    fail("Unexpected version in version history of copied node.");
  }
 catch (  VersionException e) {
  }
}
