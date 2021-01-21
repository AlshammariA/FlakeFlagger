@Test public void testRemovePolicyAcContent() throws Exception {
  for (  String acPath : getAcContentPaths()) {
    try {
      AccessControlPolicy acl=createPolicy(acPath);
      acMgr.removePolicy(acPath,acl);
      fail("Removing access control policy to access control content should fail");
    }
 catch (    AccessControlException e) {
    }
  }
}
