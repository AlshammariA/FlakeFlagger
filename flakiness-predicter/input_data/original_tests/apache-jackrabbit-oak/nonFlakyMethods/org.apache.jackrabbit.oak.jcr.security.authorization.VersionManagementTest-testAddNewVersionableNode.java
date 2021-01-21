@Test public void testAddNewVersionableNode() throws Exception {
  modify(path,REP_WRITE,true);
  modify(path,Privilege.JCR_VERSION_MANAGEMENT,true);
  Node testNode=testSession.getNode(path);
  Node newNode=testNode.addNode("versionable");
  newNode.addMixin("mix:versionable");
  testSession.save();
}
