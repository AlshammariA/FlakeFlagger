@Test public void testMoveSubTreeBack() throws Exception {
  setupMovePermissions(path,siblingPath);
  try {
    move(childNPath,siblingDestPath);
    move(siblingDestPath + '/' + nodeName3,path + "/subtreeBack");
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
}
