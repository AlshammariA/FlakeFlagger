@Test public void testCancelInheritanceRestriction() throws Exception {
  allow(path,repWritePrivileges,createGlobRestriction(""));
  assertTrue(testAcMgr.hasPrivileges(path,repWritePrivileges));
  assertTrue(testSession.hasPermission(path,Session.ACTION_SET_PROPERTY));
  assertFalse(testAcMgr.hasPrivileges(childNPath,repWritePrivileges));
  assertFalse(testSession.hasPermission(childNPath,Session.ACTION_SET_PROPERTY));
  assertFalse(testAcMgr.hasPrivileges(childNPath2,repWritePrivileges));
  assertFalse(testSession.hasPermission(childNPath2,Session.ACTION_SET_PROPERTY));
}
