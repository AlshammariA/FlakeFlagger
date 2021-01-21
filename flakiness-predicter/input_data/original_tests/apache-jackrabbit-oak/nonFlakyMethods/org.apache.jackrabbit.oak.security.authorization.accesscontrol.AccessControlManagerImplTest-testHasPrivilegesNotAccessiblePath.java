/** 
 * @since OAK 1.0 As of OAK AccessControlManager#hasPrivilege will throwPathNotFoundException in case the node associated with a given path is not readable to the editing session (compatibility with the specification which was missing in jackrabbit).
 */
@Test public void testHasPrivilegesNotAccessiblePath() throws Exception {
  List<String> notAccessible=new ArrayList();
  notAccessible.add("/");
  notAccessible.addAll(getAcContentPaths());
  Privilege[] privs=privilegesFromNames(PrivilegeConstants.JCR_ALL);
  AccessControlManagerImpl testAcMgr=getTestAccessControlManager();
  for (  String path : notAccessible) {
    try {
      testAcMgr.hasPrivileges(path,privs);
      fail("AccessControlManager#hasPrivileges for node that is not accessible should fail.");
    }
 catch (    PathNotFoundException e) {
    }
  }
  for (  String path : notAccessible) {
    try {
      testAcMgr.hasPrivileges(path,getPrincipals(getTestRoot().getContentSession()),privs);
      fail("AccessControlManager#hasPrivileges for node that is not accessible should fail.");
    }
 catch (    PathNotFoundException e) {
    }
  }
}
