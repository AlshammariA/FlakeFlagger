@Test public void testNonExistingItem() throws Exception {
  String rootPath=testSession.getRootNode().getPath();
  assertReadOnly(rootPath);
  testSession.checkPermission(rootPath + "nonExistingItem",Session.ACTION_READ);
}
