@Test public void testRemove51() throws Exception {
  Node subtree=superuser.getNode(childNPath).addNode(nodeName3);
  superuser.save();
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  allow(childNPath,rmNode);
  String subtreePath=subtree.getPath();
  assertFalse(testSession.hasPermission(subtreePath,Session.ACTION_REMOVE));
  try {
    testSession.getNode(subtreePath).remove();
    testSession.save();
    fail("Removal must fail");
  }
 catch (  AccessDeniedException e) {
  }
}
