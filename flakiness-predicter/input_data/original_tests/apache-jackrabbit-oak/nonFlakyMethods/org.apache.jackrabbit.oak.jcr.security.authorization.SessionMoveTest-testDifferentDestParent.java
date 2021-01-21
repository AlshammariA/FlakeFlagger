@Test public void testDifferentDestParent() throws Exception {
  allow(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(siblingPath,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT}));
  allow(childNPath,privilegesFromName(Privilege.JCR_REMOVE_NODE));
  move(childNPath,siblingDestPath);
}
