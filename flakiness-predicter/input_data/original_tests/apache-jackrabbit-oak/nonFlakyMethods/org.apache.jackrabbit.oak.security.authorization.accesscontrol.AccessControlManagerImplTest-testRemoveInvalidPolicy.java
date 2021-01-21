@Test public void testRemoveInvalidPolicy() throws Exception {
  ACL acl=setupPolicy(testPath);
  try {
    acMgr.removePolicy(testPath,new TestACL(testPath,getRestrictionProvider()));
    fail("Invalid policy -> removal must fail");
  }
 catch (  AccessControlException e) {
  }
  ACL repoAcl=setupPolicy(null);
  try {
    acMgr.removePolicy(testPath,repoAcl);
    fail("Setting invalid policy must fail");
  }
 catch (  AccessControlException e) {
  }
  try {
    acMgr.removePolicy(null,acl);
    fail("Setting invalid policy must fail");
  }
 catch (  AccessControlException e) {
  }
}
