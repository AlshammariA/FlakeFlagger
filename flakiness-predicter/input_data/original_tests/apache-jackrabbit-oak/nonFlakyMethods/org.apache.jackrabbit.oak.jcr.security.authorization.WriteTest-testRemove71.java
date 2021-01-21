@Test public void testRemove71() throws Exception {
  Node subtree=superuser.getNode(childNPath).addNode(nodeName3);
  superuser.save();
  Privilege[] rmChildNodes=privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES);
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  deny(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(childNPath,rmNode);
  String subtreePath=subtree.getPath();
  assertFalse(testSession.hasPermission(subtreePath,Session.ACTION_REMOVE));
  allow(childNPath,rmChildNodes);
  assertTrue(testSession.hasPermission(subtreePath,javax.jcr.Session.ACTION_REMOVE));
  assertTrue(testAcMgr.hasPrivileges(subtreePath,new Privilege[]{rmChildNodes[0],rmNode[0]}));
  testSession.getNode(subtreePath).remove();
  superuser.save();
}
