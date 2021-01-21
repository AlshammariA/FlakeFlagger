/** 
 * @see <a href="https://issues.apache.org/jira/browse/JCR-2420">JCR-2420</a>
 */
@Test public void testRemovalJCR242() throws Exception {
  Privilege[] allPriv=privilegesFromNames(new String[]{Privilege.JCR_ALL});
  allow(path,testUser.getPrincipal(),allPriv);
  allow(childNPath,testUser.getPrincipal(),allPriv);
  AccessControlManager acMgr=testSession.getAccessControlManager();
  assertTrue(acMgr.hasPrivileges(path,allPriv));
  assertTrue(acMgr.hasPrivileges(childNPath,allPriv));
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  Node child=testSession.getNode(childNPath);
  child.remove();
  testSession.save();
}
