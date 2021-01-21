/** 
 * @since OAK 1.0 As of OAK AccessControlManager#hasPrivilege will throwPathNotFoundException in case the node associated with a given path is not readable to the editing session.
 */
@Test public void testGetPrivilegesNotAccessiblePath() throws Exception {
  List<String> notAccessible=new ArrayList();
  notAccessible.add("/");
  notAccessible.addAll(getAcContentPaths());
  for (  String path : notAccessible) {
    try {
      getTestAccessControlManager().getPrivileges(path);
      fail("AccessControlManager#getPrivileges for node that is not accessible should fail.");
    }
 catch (    PathNotFoundException e) {
    }
  }
  for (  String path : notAccessible) {
    try {
      getTestAccessControlManager().getPrivileges(path,Collections.singleton(testPrincipal));
      fail("AccessControlManager#getPrivileges for node that is not accessible should fail.");
    }
 catch (    PathNotFoundException e) {
    }
  }
}
