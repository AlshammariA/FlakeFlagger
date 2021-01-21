@Test public void testAddMixVersionable2() throws Exception {
  modify(path,REP_WRITE,true);
  modify(path,Privilege.JCR_NODE_TYPE_MANAGEMENT,true);
  modify(path,Privilege.JCR_VERSION_MANAGEMENT,true);
  Node n=createVersionableNode(testSession.getNode(path));
  n.checkin();
  n.checkout();
}
