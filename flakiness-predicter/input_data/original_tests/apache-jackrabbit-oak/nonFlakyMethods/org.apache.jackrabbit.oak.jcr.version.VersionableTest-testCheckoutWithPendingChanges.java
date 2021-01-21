public void testCheckoutWithPendingChanges() throws Exception {
  Node node=testRootNode.addNode(nodeName1,testNodeType);
  node.addMixin(mixVersionable);
  superuser.save();
  node.checkin();
  Node newNode=testRootNode.addNode(nodeName2,testNodeType);
  assertTrue(newNode.isNew());
  node.checkout();
  assertTrue(node.isCheckedOut());
  assertTrue(newNode.isNew());
}
