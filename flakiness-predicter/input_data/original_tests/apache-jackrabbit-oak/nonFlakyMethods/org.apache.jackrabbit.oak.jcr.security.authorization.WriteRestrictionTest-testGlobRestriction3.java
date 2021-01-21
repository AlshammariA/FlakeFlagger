@Test public void testGlobRestriction3() throws Exception {
  Privilege[] addNode=privilegesFromName(Privilege.JCR_ADD_CHILD_NODES);
  allow(path,repWritePrivileges,createGlobRestriction("/*/" + nodeName3));
  allow(path,addNode);
  assertFalse(testAcMgr.hasPrivileges(path,repWritePrivileges));
  assertTrue(testAcMgr.hasPrivileges(path,addNode));
  assertFalse(testAcMgr.hasPrivileges(childNPath,repWritePrivileges));
  assertTrue(testAcMgr.hasPrivileges(childNPath,addNode));
  assertFalse(testAcMgr.hasPrivileges(childNPath2,repWritePrivileges));
  assertTrue(testAcMgr.hasPrivileges(nodePath3,repWritePrivileges));
}
