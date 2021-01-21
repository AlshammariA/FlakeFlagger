@Test public void testReadAccessControlWithRestriction() throws Exception {
  Privilege[] privileges=privilegesFromName(Privilege.JCR_READ_ACCESS_CONTROL);
  allow(path,privileges,createGlobRestriction('/' + nodeName2));
  assertFalse(testAcMgr.hasPrivileges(path,privileges));
  assertFalse(testSession.nodeExists(path + "/rep:policy"));
  try {
    testAcMgr.getPolicies(path);
    fail("AccessDeniedException expected");
  }
 catch (  AccessDeniedException e) {
  }
  assertTrue(testAcMgr.hasPrivileges(childNPath,privileges));
  assertEquals(0,testAcMgr.getPolicies(childNPath).length);
}
