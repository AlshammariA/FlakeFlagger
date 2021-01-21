@Test public void testGroupPermissions() throws Exception {
  allow(path,testGroup.getPrincipal(),modPropPrivileges);
  String actions=getActions(Session.ACTION_SET_PROPERTY,Session.ACTION_READ);
  assertTrue(testSession.hasPermission(path,actions));
  assertTrue(testAcMgr.hasPrivileges(path,modPropPrivileges));
}
