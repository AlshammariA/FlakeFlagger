/** 
 * @see <a href="https://issues.apache.org/jira/browse/JCR-3131">JCR-3131</a>
 */
@Test public void testEmptySaveNoRootAccess() throws Exception {
  testSession.save();
  try {
    JackrabbitAccessControlList acl=AccessControlUtils.getAccessControlList(acMgr,"/");
    acl.addEntry(testUser.getPrincipal(),readPrivileges,false);
    acMgr.setPolicy(acl.getPath(),acl);
    superuser.save();
    testSession.save();
  }
  finally {
    JackrabbitAccessControlList acl=AccessControlUtils.getAccessControlList(acMgr,"/");
    acl.addEntry(testUser.getPrincipal(),readPrivileges,true);
    acMgr.setPolicy(acl.getPath(),acl);
    superuser.save();
  }
}
