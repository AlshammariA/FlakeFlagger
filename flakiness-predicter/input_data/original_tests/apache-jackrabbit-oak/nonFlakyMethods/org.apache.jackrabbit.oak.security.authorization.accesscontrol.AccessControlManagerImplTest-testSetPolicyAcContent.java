@Test public void testSetPolicyAcContent() throws Exception {
  for (  String acPath : getAcContentPaths()) {
    try {
      AccessControlPolicy acl=createPolicy(acPath);
      acMgr.setPolicy(acPath,acl);
      fail("Setting access control policy to access control content should fail");
    }
 catch (    AccessControlException e) {
    }
  }
}
