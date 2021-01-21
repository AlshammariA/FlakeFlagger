@Test public void testReplaceNode3() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  testSession.removeItem(targetNode.getPath());
  Node newNode=testSession.getNode(childNPath).addNode(targetNode.getName(),targetNode.getPrimaryNodeType().getName());
  newNode.addMixin(getMixinName());
  try {
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
    testSession.refresh(false);
  }
}
