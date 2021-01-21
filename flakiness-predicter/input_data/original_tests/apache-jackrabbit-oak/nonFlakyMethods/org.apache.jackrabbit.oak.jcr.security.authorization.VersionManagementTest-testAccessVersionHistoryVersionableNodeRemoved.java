/** 
 * @since oak
 */
@Test public void testAccessVersionHistoryVersionableNodeRemoved() throws Exception {
  Node n=createVersionableNode(superuser.getNode(path));
  allow(n.getPath(),versionPrivileges);
  n.checkin();
  n.checkout();
  String versionablePath=n.getPath();
  VersionHistory vh=n.getVersionHistory();
  String vhPath=vh.getPath();
  String vhUUID=vh.getIdentifier();
  n.remove();
  superuser.save();
  testSession.refresh(false);
  assertTrue(testSession.nodeExists(path));
  assertFalse(testSession.nodeExists(versionablePath));
  VersionHistory history=(VersionHistory)testSession.getNode(vhPath);
  history=(VersionHistory)testSession.getNodeByIdentifier(vhUUID);
  history=(VersionHistory)testSession.getNodeByUUID(vhUUID);
  modify(path,Privilege.JCR_READ,false);
  assertFalse(testSession.nodeExists(vhPath));
}
