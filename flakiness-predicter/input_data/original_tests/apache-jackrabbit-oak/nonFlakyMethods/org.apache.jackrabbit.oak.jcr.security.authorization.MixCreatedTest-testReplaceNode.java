@Test public void testReplaceNode() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_MODIFY_PROPERTIES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
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
