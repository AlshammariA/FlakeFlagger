@Test public void testInvalidPrivilege() throws Exception {
  NodeUtil acl=createAcl();
  String privName="invalidPrivilegeName";
  createACE(acl,"invalid",NT_REP_GRANT_ACE,testPrincipal.getName(),privName);
  try {
    root.commit();
    fail("Creating an ACE with invalid privilege should fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
  }
}
