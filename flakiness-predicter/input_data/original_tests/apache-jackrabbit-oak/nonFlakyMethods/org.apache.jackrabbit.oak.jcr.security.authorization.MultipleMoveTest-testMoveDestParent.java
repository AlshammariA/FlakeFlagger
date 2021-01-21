@Test public void testMoveDestParent() throws Exception {
  setupMovePermissions(path,siblingPath);
  try {
    move(childNPath,siblingDestPath);
    move(siblingPath,path + "/parentMove");
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
}
