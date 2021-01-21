/** 
 * @since oak (DIFF: jr required jcr:versionManagement privilege on the version store)
 */
@Test public void testAccessVersionHistory() throws Exception {
  Node n=createVersionableNode(superuser.getNode(path));
  allow(n.getPath(),versionPrivileges);
  Node testNode=testSession.getNode(n.getPath());
  testNode.checkin();
  testNode.checkout();
  VersionHistory vh=testNode.getVersionHistory();
  String vhPath=vh.getPath();
  String vhUUID=vh.getIdentifier();
  assertTrue(vh.isSame(testNode.getSession().getNode(vhPath)));
  assertTrue(vh.isSame(testNode.getSession().getNodeByIdentifier(vhUUID)));
  assertTrue(vh.isSame(testNode.getSession().getNodeByUUID(vhUUID)));
}
