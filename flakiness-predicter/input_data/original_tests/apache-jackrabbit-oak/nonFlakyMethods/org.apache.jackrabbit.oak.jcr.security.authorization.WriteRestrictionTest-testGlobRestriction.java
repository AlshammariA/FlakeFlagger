@Test public void testGlobRestriction() throws Exception {
  String writeActions=getActions(Session.ACTION_ADD_NODE,Session.ACTION_REMOVE,Session.ACTION_SET_PROPERTY);
  allow(path,repWritePrivileges,createGlobRestriction("/*" + nodeName3));
  assertFalse(testAcMgr.hasPrivileges(path,repWritePrivileges));
  assertFalse(testSession.hasPermission(path,javax.jcr.Session.ACTION_SET_PROPERTY));
  assertFalse(testAcMgr.hasPrivileges(childNPath,repWritePrivileges));
  assertFalse(testSession.hasPermission(childNPath,javax.jcr.Session.ACTION_SET_PROPERTY));
  assertTrue(testAcMgr.hasPrivileges(childNPath2,repWritePrivileges));
  assertTrue(testSession.hasPermission(childNPath2,Session.ACTION_SET_PROPERTY));
  assertFalse(testSession.hasPermission(childNPath2,writeActions));
  assertTrue(testAcMgr.hasPrivileges(nodePath3,repWritePrivileges));
}
