@Test public void testRemoveSubTreeWithRestriction() throws Exception {
  allow(path,testUser.getPrincipal(),readWritePrivileges);
  deny(path,privilegesFromName(PrivilegeConstants.JCR_REMOVE_NODE),createGlobRestriction("*/" + nodeName3));
  testSession.getNode(childNPath).getNode(nodeName3).remove();
  try {
    testSession.save();
    fail("Removing child node must be denied.");
  }
 catch (  AccessDeniedException e) {
  }
}
