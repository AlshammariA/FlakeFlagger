/** 
 * @since oak (DIFF: jr required jcr:versionManagement privilege on the version store)
 */
@Test public void testRemoveVersion() throws Exception {
  Node n=createVersionableNode(superuser.getNode(path));
  Node trn=testSession.getNode(path);
  modify(trn.getPath(),Privilege.JCR_VERSION_MANAGEMENT,true);
  Node testNode=trn.getNode(n.getName());
  Version v=testNode.checkin();
  testNode.checkout();
  testNode.checkin();
  testNode.getVersionHistory().removeVersion(v.getName());
}
