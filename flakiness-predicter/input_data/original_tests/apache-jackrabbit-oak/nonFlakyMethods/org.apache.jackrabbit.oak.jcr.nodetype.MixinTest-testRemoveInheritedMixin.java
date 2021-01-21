public void testRemoveInheritedMixin() throws Exception {
  Node node=testRootNode.addNode("testRemoveInheritedMixin",NT_UNSTRUCTURED);
  node.addMixin(JcrConstants.MIX_VERSIONABLE);
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
