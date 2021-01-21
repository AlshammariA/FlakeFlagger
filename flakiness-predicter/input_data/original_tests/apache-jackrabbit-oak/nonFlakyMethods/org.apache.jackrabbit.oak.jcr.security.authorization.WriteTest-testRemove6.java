@Test public void testRemove6() throws Exception {
  Privilege[] privs=privilegesFromNames(new String[]{Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_REMOVE_NODE});
  allow(path,privs);
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  deny(childNPath,rmNode);
  assertFalse(testSession.hasPermission(path,Session.ACTION_REMOVE));
  assertFalse(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  assertTrue(testAcMgr.hasPrivileges(childNPath,privilegesFromNames(new String[]{Privilege.JCR_READ,Privilege.JCR_REMOVE_CHILD_NODES})));
  assertFalse(testAcMgr.hasPrivileges(childNPath,privilegesFromName(Privilege.JCR_REMOVE_NODE)));
  try {
    testSession.getNode(childNPath).remove();
    testSession.save();
    fail("Removal must fail");
  }
 catch (  AccessDeniedException e) {
  }
}
