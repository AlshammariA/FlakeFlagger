@Test public void testDuplicateAce() throws Exception {
  AccessControlManager acMgr=getAccessControlManager(root);
  JackrabbitAccessControlList acl=org.apache.jackrabbit.commons.jackrabbit.authorization.AccessControlUtils.getAccessControlList(acMgr,testPath);
  acl.addAccessControlEntry(testPrincipal,privilegesFromNames(PrivilegeConstants.JCR_ADD_CHILD_NODES));
  acMgr.setPolicy(testPath,acl);
  NodeUtil policy=new NodeUtil(root.getTree(testPath + "/rep:policy"));
  NodeUtil ace=policy.addChild("duplicateAce",NT_REP_GRANT_ACE);
  ace.setString(REP_PRINCIPAL_NAME,testPrincipal.getName());
  ace.setStrings(AccessControlConstants.REP_PRIVILEGES,PrivilegeConstants.JCR_ADD_CHILD_NODES);
  try {
    root.commit();
    fail("Creating duplicate ACE must be detected");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
  }
}
