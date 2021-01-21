@Test public void testHasPrivilegesInvalidPaths() throws Exception {
  Privilege[] privs=privilegesFromNames(PrivilegeConstants.JCR_ALL);
  for (  String path : getInvalidPaths()) {
    try {
      acMgr.hasPrivileges(path,privs);
      fail("AccessControlManager#hasPrivileges  for node that doesn't exist should fail.");
    }
 catch (    RepositoryException e) {
    }
  }
  for (  String path : getInvalidPaths()) {
    try {
      acMgr.hasPrivileges(path,getPrincipals(adminSession),privs);
      fail("AccessControlManager#hasPrivileges  for node that doesn't exist should fail.");
    }
 catch (    RepositoryException e) {
    }
  }
}
