@Test public void testGetPolicies() throws Exception {
  for (  String path : readPaths) {
    AccessControlPolicy[] policies=getAccessControlManager(root).getPolicies(path);
    assertTrue(policies.length > 0);
    boolean found=false;
    for (    AccessControlPolicy policy : policies) {
      if ("org.apache.jackrabbit.oak.security.authorization.accesscontrol.AccessControlManagerImpl$ReadPolicy".equals(policy.getClass().getName())) {
        found=true;
        break;
      }
    }
    assertTrue(found);
  }
}
