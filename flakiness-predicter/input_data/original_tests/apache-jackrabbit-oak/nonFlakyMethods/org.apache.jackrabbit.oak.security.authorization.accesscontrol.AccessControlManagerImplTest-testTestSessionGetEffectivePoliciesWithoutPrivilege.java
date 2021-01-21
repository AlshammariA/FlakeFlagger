@Test public void testTestSessionGetEffectivePoliciesWithoutPrivilege() throws Exception {
  Privilege[] privileges=privilegesFromNames(PrivilegeConstants.JCR_READ);
  setupPolicy(testPath,privileges);
  root.commit();
  Root testRoot=getTestRoot();
  testRoot.refresh();
  AccessControlManager testAcMgr=getTestAccessControlManager();
  List<String> paths=ImmutableList.of(testPath,NodeTypeConstants.NODE_TYPES_PATH);
  for (  String path : paths) {
    assertFalse(testAcMgr.hasPrivileges(path,privilegesFromNames(PrivilegeConstants.JCR_READ_ACCESS_CONTROL)));
    try {
      testAcMgr.getEffectivePolicies(path);
      fail("READ_ACCESS_CONTROL is not granted at " + path);
    }
 catch (    AccessDeniedException e) {
    }
  }
}
