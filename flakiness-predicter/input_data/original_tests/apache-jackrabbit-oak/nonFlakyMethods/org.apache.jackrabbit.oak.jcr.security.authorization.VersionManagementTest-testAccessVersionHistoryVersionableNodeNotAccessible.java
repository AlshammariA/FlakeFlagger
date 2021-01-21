/** 
 * @since oak (DIFF: jr required jcr:versionManagement privilege on the version store)
 */
@Test public void testAccessVersionHistoryVersionableNodeNotAccessible() throws Exception {
  Node n=createVersionableNode(superuser.getNode(path));
  allow(n.getPath(),versionPrivileges);
  Node testNode=testSession.getNode(n.getPath());
  testNode.checkin();
  testNode.checkout();
  VersionHistory vh=testNode.getVersionHistory();
  String vhPath=vh.getPath();
  String vhUUID=vh.getIdentifier();
  modify(n.getPath(),Privilege.JCR_READ,false);
  assertFalse(testSession.nodeExists(n.getPath()));
  try {
    VersionHistory history=(VersionHistory)testSession.getNode(vhPath);
    fail("Access to version history should be denied if versionable node is not accessible");
  }
 catch (  PathNotFoundException e) {
  }
  try {
    VersionHistory history=(VersionHistory)testSession.getNodeByIdentifier(vhUUID);
    fail("Access to version history should be denied if versionable node is not accessible");
  }
 catch (  ItemNotFoundException e) {
  }
  try {
    VersionHistory history=(VersionHistory)testSession.getNodeByUUID(vhUUID);
    fail("Access to version history should be denied if versionable node is not accessible");
  }
 catch (  ItemNotFoundException e) {
  }
}
