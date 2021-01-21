/** 
 * @since oak
 */
@Test public void testAddVersionLabel() throws Exception {
  Node n=createVersionableNode(superuser.getNode(path));
  allow(n.getPath(),versionPrivileges);
  Node testNode=testSession.getNode(n.getPath());
  Version v=testNode.checkin();
  testNode.checkout();
  Version v2=testNode.checkin();
  testNode.checkout();
  VersionHistory history=testNode.getVersionHistory();
  history.addVersionLabel(v.getName(),"testLabel",false);
  history.addVersionLabel(v2.getName(),"testLabel",true);
  VersionManager vMgr=testSession.getWorkspace().getVersionManager();
  history=vMgr.getVersionHistory(testNode.getPath());
  history.addVersionLabel(v.getName(),"testLabel",true);
}
