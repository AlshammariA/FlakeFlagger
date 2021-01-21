@Test public void testInheritanceAndMixedUserGroupPermissions() throws Exception {
  allow(path,testGroup.getPrincipal(),modPropPrivileges);
  deny(path,testUser.getPrincipal(),modPropPrivileges);
  assertFalse(testAcMgr.hasPrivileges(path,modPropPrivileges));
  allow(childNPath,testGroup.getPrincipal(),modPropPrivileges);
  assertFalse(testAcMgr.hasPrivileges(childNPath,modPropPrivileges));
}
