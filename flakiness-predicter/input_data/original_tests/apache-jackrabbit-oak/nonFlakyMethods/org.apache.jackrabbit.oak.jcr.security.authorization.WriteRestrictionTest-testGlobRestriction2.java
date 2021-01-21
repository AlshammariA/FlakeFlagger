@Test public void testGlobRestriction2() throws Exception {
  Privilege[] addNode=privilegesFromName(Privilege.JCR_ADD_CHILD_NODES);
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  allow(path,repWritePrivileges,createGlobRestriction("/*/" + nodeName3));
  assertFalse(testAcMgr.hasPrivileges(path,repWritePrivileges));
  assertFalse(testAcMgr.hasPrivileges(path,rmNode));
  assertFalse(testAcMgr.hasPrivileges(childNPath,addNode));
  assertFalse(testAcMgr.hasPrivileges(childNPath2,repWritePrivileges));
  assertTrue(testAcMgr.hasPrivileges(nodePath3,repWritePrivileges));
}
