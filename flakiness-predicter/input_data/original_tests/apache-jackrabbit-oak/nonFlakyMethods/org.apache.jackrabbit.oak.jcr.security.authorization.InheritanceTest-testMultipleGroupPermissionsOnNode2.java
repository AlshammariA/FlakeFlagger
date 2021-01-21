@Test public void testMultipleGroupPermissionsOnNode2() throws Exception {
  deny(path,testGroup.getPrincipal(),modPropPrivileges);
  allow(path,group2.getPrincipal(),modPropPrivileges);
  String actions=getActions(Session.ACTION_SET_PROPERTY,Session.ACTION_READ);
  assertTrue(testSession.hasPermission(path,actions));
  assertTrue(testAcMgr.hasPrivileges(path,modPropPrivileges));
}
