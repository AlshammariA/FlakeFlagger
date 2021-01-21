@Test public void testSetPolicyAtDifferentPath() throws Exception {
  try {
    ACL acl=getApplicablePolicy(testPath);
    acMgr.setPolicy("/",acl);
    fail("Setting access control policy at a different node path must fail");
  }
 catch (  AccessControlException e) {
  }
}
