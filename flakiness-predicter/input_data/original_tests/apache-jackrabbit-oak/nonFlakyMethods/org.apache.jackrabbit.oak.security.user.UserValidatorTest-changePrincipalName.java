@Test public void changePrincipalName() throws Exception {
  try {
    Tree userTree=root.getTree(userPath);
    userTree.setProperty(REP_PRINCIPAL_NAME,"another");
    root.commit();
    fail("changing the principal name should fail");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
