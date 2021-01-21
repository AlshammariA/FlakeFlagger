public void testRemoveMixinWithoutMixinProperty() throws Exception {
  Node node=testRootNode.addNode("testRemoveMixinWithoutMixinProperty",NT_UNSTRUCTURED);
  superuser.save();
  try {
    node.removeMixin(JcrConstants.MIX_REFERENCEABLE);
    fail();
  }
 catch (  NoSuchNodeTypeException e) {
  }
 finally {
    node.remove();
    superuser.save();
  }
}
