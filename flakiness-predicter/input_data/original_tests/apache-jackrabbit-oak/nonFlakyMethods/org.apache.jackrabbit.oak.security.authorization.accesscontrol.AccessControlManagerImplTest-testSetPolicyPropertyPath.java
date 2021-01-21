@Test public void testSetPolicyPropertyPath() throws Exception {
  try {
    String path="/jcr:primaryType";
    AccessControlPolicy acl=createPolicy(path);
    acMgr.setPolicy(path,acl);
    fail("Setting access control policy at property path should fail");
  }
 catch (  PathNotFoundException e) {
  }
}
