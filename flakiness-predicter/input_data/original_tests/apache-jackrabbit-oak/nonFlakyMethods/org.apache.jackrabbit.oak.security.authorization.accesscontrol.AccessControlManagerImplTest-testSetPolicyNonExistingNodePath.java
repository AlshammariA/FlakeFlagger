@Test public void testSetPolicyNonExistingNodePath() throws Exception {
  try {
    String path="/non/existing";
    AccessControlPolicy acl=createPolicy(path);
    acMgr.setPolicy(path,acl);
    fail("Setting access control policy for non-existing node path should fail");
  }
 catch (  PathNotFoundException e) {
  }
}
