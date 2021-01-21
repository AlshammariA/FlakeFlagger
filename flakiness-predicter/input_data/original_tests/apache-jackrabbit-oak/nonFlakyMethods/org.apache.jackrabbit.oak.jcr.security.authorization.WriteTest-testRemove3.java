@Test public void testRemove3() throws Exception {
  Privilege[] privs=privilegesFromNames(new String[]{Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_REMOVE_NODE});
  allow(path,privs);
  assertFalse(testSession.hasPermission(path,javax.jcr.Session.ACTION_REMOVE));
  assertTrue(testSession.hasPermission(childNPath,javax.jcr.Session.ACTION_REMOVE));
  assertTrue(testAcMgr.hasPrivileges(path,privs));
  assertTrue(testAcMgr.hasPrivileges(childNPath,privs));
}
