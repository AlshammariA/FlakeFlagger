@Test public void testRegisterPrivilege() throws Exception {
  try {
    Workspace testWsp=testSession.getWorkspace();
    ((JackrabbitWorkspace)testWsp).getPrivilegeManager().registerPrivilege(getNewPrivilegeName(testWsp),false,new String[0]);
    fail("Privilege registration should be denied.");
  }
 catch (  AccessDeniedException e) {
  }
}
