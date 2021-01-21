@Test public void testRemove61() throws Exception {
  Node subtree=superuser.getNode(childNPath).addNode(nodeName3);
  superuser.save();
  Privilege[] privs=privilegesFromNames(new String[]{Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_REMOVE_NODE});
  allow(path,privs);
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  deny(childNPath,rmNode);
  String subtreePath=subtree.getPath();
  assertFalse(testSession.hasPermission(subtreePath,Session.ACTION_REMOVE));
  assertTrue(testAcMgr.hasPrivileges(subtreePath,privilegesFromNames(new String[]{Privilege.JCR_READ,Privilege.JCR_REMOVE_CHILD_NODES})));
  assertFalse(testAcMgr.hasPrivileges(subtreePath,privilegesFromName(Privilege.JCR_REMOVE_NODE)));
  try {
    testSession.getNode(subtreePath).remove();
    testSession.save();
    fail("Removal must fail");
  }
 catch (  AccessDeniedException e) {
  }
}
