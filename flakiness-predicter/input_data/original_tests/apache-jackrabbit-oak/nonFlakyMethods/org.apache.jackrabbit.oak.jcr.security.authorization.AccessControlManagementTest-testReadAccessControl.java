@Test public void testReadAccessControl() throws Exception {
  Privilege[] privileges=privilegesFromName(Privilege.JCR_READ_ACCESS_CONTROL);
  allow(path,privileges);
  assertTrue(testAcMgr.hasPrivileges(path,privileges));
  assertTrue(testSession.nodeExists(path + "/rep:policy"));
  testAcMgr.getPolicies(path);
  assertTrue(testAcMgr.hasPrivileges(childNPath,privileges));
  assertEquals(0,testAcMgr.getPolicies(childNPath).length);
}
