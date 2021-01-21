public void testRemoveAddMixVersionable() throws Exception {
  Node node=testRootNode.addNode(nodeName1);
  node.addMixin(mixVersionable);
  superuser.save();
  String vhId=node.getVersionHistory().getUUID();
  node.removeMixin(mixVersionable);
  node.addMixin(mixVersionable);
  superuser.save();
  assertFalse(vhId.equals(node.getVersionHistory().getUUID()));
}
