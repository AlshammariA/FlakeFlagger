@Test public void testChildNodes() throws Exception {
  Node n=superuser.getNode(path);
  for (int i=0; i < 5; i++) {
    n=n.addNode(nodeName4,testNodeType);
  }
  superuser.save();
  testSession.refresh(false);
  String childPath=n.getPath();
  assertArrayEquals(readPrivileges,testAcMgr.getPrivileges(childPath));
  testSession.checkPermission(childPath,Session.ACTION_READ);
}
