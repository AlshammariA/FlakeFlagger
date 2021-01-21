@Test public void testInheritedGroupPermissions() throws Exception {
  allow(path,testGroup.getPrincipal(),modPropPrivileges);
  deny(childNPath,EveryonePrincipal.getInstance(),modPropPrivileges);
  assertFalse(testAcMgr.hasPrivileges(childNPath,modPropPrivileges));
}
