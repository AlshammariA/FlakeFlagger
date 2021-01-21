@Test public void testGetPrivilegesInvalidPaths() throws Exception {
  for (  String path : getInvalidPaths()) {
    try {
      acMgr.getPrivileges(path);
      fail("AccessControlManager#getPrivileges  for node that doesn't exist should fail.");
    }
 catch (    RepositoryException e) {
    }
  }
  for (  String path : getInvalidPaths()) {
    try {
      acMgr.getPrivileges(path,Collections.singleton(testPrincipal));
      fail("AccessControlManager#getPrivileges  for node that doesn't exist should fail.");
    }
 catch (    RepositoryException e) {
    }
  }
}
