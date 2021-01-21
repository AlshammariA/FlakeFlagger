@Test public void changeUUID() throws Exception {
  try {
    Tree userTree=root.getTree(userPath);
    userTree.setProperty(JcrConstants.JCR_UUID,UUID.randomUUID().toString());
    root.commit();
    fail("changing jcr:uuid should fail if it the uuid valid is invalid");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
