@Test public void testCanReadProperties2() throws Exception {
  AccessControlManager acMgr=getAccessControlManager(root);
  JackrabbitAccessControlList acl=AccessControlUtils.getAccessControlList(acMgr,"/test");
  acl.addEntry(getTestUser().getPrincipal(),privilegesFromNames(PrivilegeConstants.JCR_READ),true);
  acMgr.setPolicy("/test",acl);
  root.commit();
  Tree policyTree=root.getTree("/test/rep:policy");
  NodeUtil ace=new NodeUtil(policyTree).addChild("ace2",NT_REP_DENY_ACE);
  ace.setNames(REP_PRIVILEGES,PrivilegeConstants.REP_READ_PROPERTIES);
  ace.setString(REP_PRINCIPAL_NAME,getTestUser().getPrincipal().getName());
  root.commit();
  TreePermission tp=getTreePermission("/test");
  assertFalse(tp.canReadProperties());
  assertTrue(tp.canRead());
  assertFalse(tp.canReadProperties());
}
