public void testRemoveAddMixVersionable1() throws Exception {
  Node node=testRootNode.addNode(nodeName1);
  node.addMixin(mixReferenceable);
  node.addMixin(mixVersionable);
  superuser.save();
  String vhId=node.getVersionHistory().getUUID();
  node.removeMixin(mixVersionable);
  node.addMixin(mixVersionable);
  superuser.save();
  assertEquals(vhId,node.getVersionHistory().getUUID());
}
