public void testReadOnlyAfterCheckin() throws RepositoryException {
  Node node=testRootNode.addNode(nodeName1,testNodeType);
  node.addMixin(mixVersionable);
  superuser.save();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  vMgr.checkin(node.getPath());
  try {
    node.setProperty(propertyName1,"value");
    fail("setProperty() must fail on a checked-in node");
  }
 catch (  VersionException e) {
  }
}
