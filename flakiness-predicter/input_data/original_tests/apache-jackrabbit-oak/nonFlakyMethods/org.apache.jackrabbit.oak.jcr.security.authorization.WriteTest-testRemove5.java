@Test public void testRemove5() throws Exception {
  Privilege[] rmNode=privilegesFromName(Privilege.JCR_REMOVE_NODE);
  allow(childNPath,rmNode);
  assertFalse(testSession.hasPermission(childNPath,Session.ACTION_REMOVE));
  try {
    testSession.getNode(childNPath).remove();
    testSession.save();
    fail("Removal must fail");
  }
 catch (  AccessDeniedException e) {
  }
}
