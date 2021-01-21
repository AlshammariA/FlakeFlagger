@Test public void testInheritedGroupPermissions2() throws Exception {
  allow(path,EveryonePrincipal.getInstance(),modPropPrivileges);
  deny(childNPath,testGroup.getPrincipal(),modPropPrivileges);
  assertFalse(testAcMgr.hasPrivileges(childNPath,modPropPrivileges));
}
