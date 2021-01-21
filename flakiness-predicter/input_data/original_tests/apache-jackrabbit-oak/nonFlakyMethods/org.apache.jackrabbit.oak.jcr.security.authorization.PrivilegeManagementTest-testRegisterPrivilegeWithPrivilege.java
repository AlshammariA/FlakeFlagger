@Test public void testRegisterPrivilegeWithPrivilege() throws Exception {
  modify(null,PrivilegeConstants.REP_PRIVILEGE_MANAGEMENT,true);
  try {
    Workspace testWsp=testSession.getWorkspace();
    ((JackrabbitWorkspace)testWsp).getPrivilegeManager().registerPrivilege(getNewPrivilegeName(testWsp),false,new String[0]);
  }
  finally {
    modify(null,PrivilegeConstants.REP_PRIVILEGE_MANAGEMENT,false);
  }
}
