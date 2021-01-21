public void testRemoveAndCreateSameVersionableChildNode() throws Exception {
  Node parentNode=testRootNode.addNode("parent");
  parentNode.setPrimaryType(ntUnstructured);
  parentNode.setProperty("name","sample");
  Node createdNode=parentNode.addNode("versionablechild","nt:unstructured");
  createdNode.addMixin(mixVersionable);
  superuser.save();
  VersionManager vm=superuser.getWorkspace().getVersionManager();
  vm.checkin(testRootNode.getPath() + "/parent/versionablechild");
  Node parent=testRootNode.getNode("parent");
  NodeIterator nodes=parent.getNodes();
  while (nodes.hasNext()) {
    Node childNode=nodes.nextNode();
    childNode.remove();
  }
  Node recreatedNode=parent.addNode("versionablechild",ntUnstructured);
  recreatedNode.addMixin(mixVersionable);
  superuser.save();
}
