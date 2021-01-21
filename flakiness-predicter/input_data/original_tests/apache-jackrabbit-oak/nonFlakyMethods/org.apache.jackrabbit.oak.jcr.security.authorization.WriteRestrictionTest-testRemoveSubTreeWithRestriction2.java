@Test public void testRemoveSubTreeWithRestriction2() throws Exception {
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(path,privilegesFromName(PrivilegeConstants.JCR_REMOVE_CHILD_NODES),createGlobRestriction("*/" + Text.getName(childNPath)));
  testSession.getNode(childNPath).getNode(nodeName3).remove();
  try {
    testSession.save();
    fail("Removing child node must be denied.");
  }
 catch (  AccessDeniedException e) {
  }
}
