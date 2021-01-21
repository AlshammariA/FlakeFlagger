@Test public void testMissingJcrAddChildNodesAtDestParent() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_REMOVE_CHILD_NODES}));
  try {
    move(childNPath,siblingDestPath);
    fail("Move requires addChildNodes privilege at dest parent");
  }
 catch (  AccessDeniedException e) {
  }
}
