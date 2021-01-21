@Test public void testMixedUserGroupPermissions() throws Exception {
  deny(path,testUser.getPrincipal(),modPropPrivileges);
  allow(path,testGroup.getPrincipal(),modPropPrivileges);
  assertFalse(testSession.hasPermission(path,Session.ACTION_SET_PROPERTY));
  assertFalse(testAcMgr.hasPrivileges(path,modPropPrivileges));
}
