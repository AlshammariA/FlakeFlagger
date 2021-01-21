@Test public void testRemovePolicyAtDifferentPath() throws Exception {
  try {
    setupPolicy(testPath);
    ACL acl=getApplicablePolicy("/");
    acMgr.removePolicy(testPath,acl);
    fail("Removing access control policy at a different node path must fail");
  }
 catch (  AccessControlException e) {
  }
}
