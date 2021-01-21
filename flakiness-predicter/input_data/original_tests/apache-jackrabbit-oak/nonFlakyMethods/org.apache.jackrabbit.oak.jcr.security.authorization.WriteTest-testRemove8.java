public void testRemove8() throws Exception {
  Privilege[] rmChildNodes=privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES);
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  allow(path,rmChildNodes);
  deny(path,rmNode);
  allow(childNPath,rmNode);
  assertTrue(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  assertTrue(testAcMgr.hasPrivileges(childNPath,new Privilege[]{rmChildNodes[0],rmNode[0]}));
  testSession.getNode(childNPath).remove();
  testSession.save();
}
