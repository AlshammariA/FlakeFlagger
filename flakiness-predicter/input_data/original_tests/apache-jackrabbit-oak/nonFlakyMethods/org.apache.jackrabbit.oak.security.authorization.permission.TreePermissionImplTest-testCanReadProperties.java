@Test public void testCanReadProperties() throws Exception {
  AccessControlManager acMgr=getAccessControlManager(root);
  JackrabbitAccessControlList acl=AccessControlUtils.getAccessControlList(acMgr,"/test");
  acl.addEntry(testPrincipal,privilegesFromNames(PrivilegeConstants.JCR_READ),true);
  acl.addEntry(testPrincipal,privilegesFromNames(PrivilegeConstants.REP_READ_PROPERTIES),false);
  acMgr.setPolicy("/test",acl);
  root.commit();
  TreePermission tp=getTreePermission("/test");
  assertFalse(tp.canReadProperties());
  assertTrue(tp.canRead());
  assertFalse(tp.canReadProperties());
}
