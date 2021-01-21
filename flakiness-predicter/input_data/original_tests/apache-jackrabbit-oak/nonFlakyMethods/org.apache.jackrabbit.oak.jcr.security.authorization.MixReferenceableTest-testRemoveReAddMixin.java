@Test public void testRemoveReAddMixin() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_REMOVE_NODE,Privilege.JCR_REMOVE_CHILD_NODES}));
  try {
    Node refNode=testSession.getNode(targetNode.getPath());
    refNode.removeMixin(getMixinName());
    refNode.addMixin(getMixinName());
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
}
