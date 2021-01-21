@Test public void changePasswordToPlainText() throws Exception {
  try {
    Tree userTree=root.getTree(userPath);
    userTree.setProperty(REP_PASSWORD,"plaintext");
    root.commit();
    fail("storing a plaintext password should fail");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
