@Test public void testGetPrivilegesFromInvalidName2() throws RepositoryException {
  String nonExistingPrivilegeName="{http://www.nonexisting.com/1.0}nonexisting";
  try {
    privilegeManager.getPrivilege(nonExistingPrivilegeName);
  }
 catch (  AccessControlException e) {
  }
}
