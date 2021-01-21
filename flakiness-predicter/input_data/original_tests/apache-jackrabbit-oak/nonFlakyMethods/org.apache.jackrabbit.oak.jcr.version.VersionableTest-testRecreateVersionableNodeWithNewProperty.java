public void testRecreateVersionableNodeWithNewProperty() throws Exception {
  Node node=testRootNode.addNode(nodeName1,ntUnstructured);
  node.addMixin(mixVersionable);
  superuser.save();
  VersionManager vm=superuser.getWorkspace().getVersionManager();
  vm.checkin(node.getPath());
  node.remove();
  node=testRootNode.addNode(nodeName1,ntUnstructured);
  node.addMixin(mixVersionable);
  node.setProperty(propertyName1,"bar");
  superuser.save();
}
