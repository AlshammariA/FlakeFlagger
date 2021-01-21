@Test public void testMoveSubTreeBack3() throws Exception {
  setupMovePermissions(path,siblingPath);
  try {
    move(childNPath,siblingDestPath);
    move(siblingDestPath + '/' + nodeName3,childNPath);
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
}
