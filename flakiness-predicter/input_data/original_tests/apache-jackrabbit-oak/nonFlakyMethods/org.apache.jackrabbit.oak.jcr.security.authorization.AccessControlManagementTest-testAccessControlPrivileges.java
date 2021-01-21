@Test public void testAccessControlPrivileges() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{REP_WRITE,Privilege.JCR_READ_ACCESS_CONTROL,Privilege.JCR_MODIFY_ACCESS_CONTROL});
  JackrabbitAccessControlList acl=allow(path,privileges);
  assertTrue(testSession.itemExists(acl.getPath() + "/rep:policy"));
  testAcMgr.getPolicies(acl.getPath());
  testAcMgr.removePolicy(acl.getPath(),acl);
}
