@Test public void testRemove4() throws Exception {
  Privilege[] rmChildNodes=privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES);
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  allow(path,rmChildNodes);
  allow(childNPath,rmNode);
  assertFalse(testSession.hasPermission(path,javax.jcr.Session.ACTION_REMOVE));
  assertTrue(testSession.hasPermission(childNPath,javax.jcr.Session.ACTION_REMOVE));
  assertTrue(testAcMgr.hasPrivileges(childNPath,new Privilege[]{rmChildNodes[0],rmNode[0]}));
  testSession.getNode(childNPath).remove();
  testSession.save();
}
