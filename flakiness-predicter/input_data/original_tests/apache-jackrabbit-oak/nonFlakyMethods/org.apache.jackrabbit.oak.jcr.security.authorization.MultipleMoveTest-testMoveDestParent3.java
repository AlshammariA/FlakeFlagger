@Test public void testMoveDestParent3() throws Exception {
  setupMovePermissions(path,siblingPath);
  try {
    move(childNPath,siblingDestPath);
    move(siblingPath,childNPath);
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
}
