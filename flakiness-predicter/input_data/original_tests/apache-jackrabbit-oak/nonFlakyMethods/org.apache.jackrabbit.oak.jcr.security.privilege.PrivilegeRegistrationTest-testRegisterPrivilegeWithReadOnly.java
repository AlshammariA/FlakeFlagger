@Test public void testRegisterPrivilegeWithReadOnly() throws RepositoryException {
  Session readOnly=getReadOnlySession();
  try {
    getPrivilegeManager(readOnly).registerPrivilege("test",true,new String[0]);
    fail("Only admin is allowed to register privileges.");
  }
 catch (  AccessDeniedException e) {
  }
 finally {
    readOnly.logout();
  }
}
