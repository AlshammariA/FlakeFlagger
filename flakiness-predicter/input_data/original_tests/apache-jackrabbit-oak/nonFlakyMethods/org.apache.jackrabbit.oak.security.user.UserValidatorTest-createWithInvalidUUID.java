@Test public void createWithInvalidUUID() throws Exception {
  try {
    User user=getUserManager(root).createUser("withInvalidUUID","pw");
    Tree tree=root.getTree(userPath);
    tree.setProperty(JcrConstants.JCR_UUID,UUID.randomUUID().toString());
    root.commit();
    fail("creating user with invalid jcr:uuid should fail");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
