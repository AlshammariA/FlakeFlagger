@Test public void removePassword() throws Exception {
  try {
    Tree userTree=root.getTree(userPath);
    userTree.removeProperty(REP_PASSWORD);
    root.commit();
    fail("removing password should fail");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
