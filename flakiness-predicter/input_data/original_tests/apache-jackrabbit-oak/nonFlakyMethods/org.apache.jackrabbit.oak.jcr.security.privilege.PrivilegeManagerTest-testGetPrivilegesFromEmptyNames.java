@Test public void testGetPrivilegesFromEmptyNames(){
  try {
    privilegeManager.getPrivilege("");
    fail("invalid privilege name array");
  }
 catch (  AccessControlException e) {
  }
catch (  RepositoryException e) {
  }
}
