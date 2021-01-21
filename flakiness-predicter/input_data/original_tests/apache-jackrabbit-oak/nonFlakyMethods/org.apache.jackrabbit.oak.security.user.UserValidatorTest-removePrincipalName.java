@Test public void removePrincipalName() throws Exception {
  try {
    Tree userTree=root.getTree(userPath);
    userTree.removeProperty(REP_PRINCIPAL_NAME);
    root.commit();
    fail("removing principal name should fail");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
