@Test public void testAbstractPrivilege() throws Exception {
  PrivilegeManager pMgr=getPrivilegeManager(root);
  pMgr.registerPrivilege("abstractPrivilege",true,new String[0]);
  NodeUtil acl=createAcl();
  createACE(acl,"invalid",NT_REP_GRANT_ACE,testPrincipal.getName(),"abstractPrivilege");
  try {
    root.commit();
    fail("Creating an ACE with an abstract privilege should fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
  }
}
