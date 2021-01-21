public void testVersionablePaths() throws Exception {
  testRootNode.addMixin(JcrConstants.MIX_VERSIONABLE);
  superuser.save();
  Node vh=getVersionManager().getVersionHistory(testRootNode.getPath());
  assertTrue(vh.isNodeType("rep:VersionablePaths"));
  String workspaceName=superuser.getWorkspace().getName();
  assertTrue(vh.hasProperty(workspaceName));
  assertEquals(testRootNode.getPath(),vh.getProperty(workspaceName).getString());
}
