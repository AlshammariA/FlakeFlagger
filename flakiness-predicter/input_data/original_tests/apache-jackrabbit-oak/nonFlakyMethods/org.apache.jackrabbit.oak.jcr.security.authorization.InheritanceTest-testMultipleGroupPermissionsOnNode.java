@Test public void testMultipleGroupPermissionsOnNode() throws Exception {
  allow(path,testGroup.getPrincipal(),modPropPrivileges);
  deny(path,group2.getPrincipal(),modPropPrivileges);
  String actions=getActions(Session.ACTION_SET_PROPERTY,Session.ACTION_READ);
  assertFalse(testSession.hasPermission(path,actions));
  assertFalse(testAcMgr.hasPrivileges(path,modPropPrivileges));
}
