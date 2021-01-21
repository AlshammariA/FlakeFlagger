@Test public void testGetPrivilegesFromInvalidName() throws RepositoryException {
  try {
    privilegeManager.getPrivilege("unknown");
    fail("invalid privilege name");
  }
 catch (  AccessControlException e) {
  }
}
