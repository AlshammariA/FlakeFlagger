@Test public void testSetPolicyInvalidPath() throws Exception {
  for (  String invalid : getInvalidPaths()) {
    try {
      AccessControlPolicy acl=createPolicy(invalid);
      acMgr.setPolicy(invalid,acl);
      fail("Setting access control policy with invalid path should fail");
    }
 catch (    RepositoryException e) {
    }
  }
}
