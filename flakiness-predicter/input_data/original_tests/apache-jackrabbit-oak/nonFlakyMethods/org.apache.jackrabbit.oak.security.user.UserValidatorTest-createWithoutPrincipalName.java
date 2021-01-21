@Test public void createWithoutPrincipalName() throws Exception {
  try {
    User user=getUserManager(root).createUser("withoutPrincipalName","pw");
    Tree tree=root.getTree(userPath);
    tree.removeProperty(REP_PRINCIPAL_NAME);
    root.commit();
    fail("creating user with invalid jcr:uuid should fail");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
