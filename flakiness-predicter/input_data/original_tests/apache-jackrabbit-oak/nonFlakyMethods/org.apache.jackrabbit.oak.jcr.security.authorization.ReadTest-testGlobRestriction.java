@Test public void testGlobRestriction() throws Exception {
  deny(path,readPrivileges,createGlobRestriction("*/" + jcrPrimaryType));
  assertTrue(testAcMgr.hasPrivileges(path,readPrivileges));
  assertTrue(testSession.hasPermission(path,javax.jcr.Session.ACTION_READ));
  testSession.getNode(path);
  assertTrue(testAcMgr.hasPrivileges(childNPath,readPrivileges));
  assertTrue(testSession.hasPermission(childNPath,javax.jcr.Session.ACTION_READ));
  testSession.getNode(childNPath);
  String propPath=path + '/' + jcrPrimaryType;
  assertFalse(testSession.hasPermission(propPath,javax.jcr.Session.ACTION_READ));
  assertFalse(testSession.propertyExists(propPath));
  propPath=childNPath + '/' + jcrPrimaryType;
  assertFalse(testSession.hasPermission(propPath,javax.jcr.Session.ACTION_READ));
  assertFalse(testSession.propertyExists(propPath));
}
