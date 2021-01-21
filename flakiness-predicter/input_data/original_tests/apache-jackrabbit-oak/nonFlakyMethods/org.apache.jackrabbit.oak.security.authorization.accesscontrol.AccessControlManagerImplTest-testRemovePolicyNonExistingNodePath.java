@Test public void testRemovePolicyNonExistingNodePath() throws Exception {
  try {
    String path="/non/existing";
    AccessControlPolicy acl=createPolicy(path);
    acMgr.removePolicy(path,acl);
    fail("Removing access control policy for non-existing node path should fail");
  }
 catch (  PathNotFoundException e) {
  }
}
