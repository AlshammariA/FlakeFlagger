public void testRemoveMixVersionable() throws Exception {
  Node node=testRootNode.addNode(nodeName1);
  node.addMixin(mixVersionable);
  superuser.save();
  node.removeMixin(mixVersionable);
  superuser.save();
}
