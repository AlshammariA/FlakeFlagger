@Test public void testSetInvalidPolicy() throws Exception {
  try {
    acMgr.setPolicy(testPath,new TestACL(testPath,getRestrictionProvider()));
    fail("Setting invalid policy must fail");
  }
 catch (  AccessControlException e) {
  }
  ACL acl=setupPolicy(testPath);
  try {
    acMgr.setPolicy(testPath,new TestACL(testPath,getRestrictionProvider()));
    fail("Setting invalid policy must fail");
  }
 catch (  AccessControlException e) {
  }
  ACL repoAcl=setupPolicy(null);
  try {
    acMgr.setPolicy(testPath,repoAcl);
    fail("Setting invalid policy must fail");
  }
 catch (  AccessControlException e) {
  }
  try {
    acMgr.setPolicy(null,acl);
    fail("Setting invalid policy must fail");
  }
 catch (  AccessControlException e) {
  }
}
