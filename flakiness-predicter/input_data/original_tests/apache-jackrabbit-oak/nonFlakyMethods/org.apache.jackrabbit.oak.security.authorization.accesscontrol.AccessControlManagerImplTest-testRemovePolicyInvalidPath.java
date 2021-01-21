@Test public void testRemovePolicyInvalidPath() throws Exception {
  for (  String invalid : getInvalidPaths()) {
    try {
      AccessControlPolicy acl=createPolicy(invalid);
      acMgr.removePolicy(invalid,acl);
      fail("Removing access control policy with invalid path should fail");
    }
 catch (    RepositoryException e) {
    }
  }
}
