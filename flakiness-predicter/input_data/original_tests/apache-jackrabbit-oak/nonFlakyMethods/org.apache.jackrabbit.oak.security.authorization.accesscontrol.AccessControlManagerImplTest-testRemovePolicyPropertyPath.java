@Test public void testRemovePolicyPropertyPath() throws Exception {
  try {
    String path="/jcr:primaryType";
    AccessControlPolicy acl=createPolicy(path);
    acMgr.removePolicy(path,acl);
    fail("Removing access control policy at property path should fail");
  }
 catch (  PathNotFoundException e) {
  }
}
