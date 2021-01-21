@Test public void testGlobRestriction4() throws Exception {
  Privilege[] addNode=privilegesFromName(Privilege.JCR_ADD_CHILD_NODES);
  allow(path,repWritePrivileges,createGlobRestriction("/*" + nodeName3));
  deny(childNPath2,addNode);
  assertFalse(testAcMgr.hasPrivileges(path,repWritePrivileges));
  assertFalse(testSession.hasPermission(path,javax.jcr.Session.ACTION_REMOVE));
  assertFalse(testAcMgr.hasPrivileges(childNPath,repWritePrivileges));
  assertFalse(testSession.hasPermission(childNPath,javax.jcr.Session.ACTION_REMOVE));
  assertFalse(testAcMgr.hasPrivileges(childNPath2,repWritePrivileges));
  assertTrue(testAcMgr.hasPrivileges(nodePath3,repWritePrivileges));
}
