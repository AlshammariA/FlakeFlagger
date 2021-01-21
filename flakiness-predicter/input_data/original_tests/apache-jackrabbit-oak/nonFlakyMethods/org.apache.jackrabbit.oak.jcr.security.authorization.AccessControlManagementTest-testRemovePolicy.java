@Test public void testRemovePolicy() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{Privilege.JCR_READ,Privilege.JCR_READ_ACCESS_CONTROL,Privilege.JCR_MODIFY_ACCESS_CONTROL});
  allow(path,privileges);
  assertTrue(testAcMgr.hasPrivileges(path,privilegesFromName(Privilege.JCR_MODIFY_ACCESS_CONTROL)));
  testAcMgr.removePolicy(path,testAcMgr.getPolicies(path)[0]);
  testSession.save();
}
