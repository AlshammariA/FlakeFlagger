@Test public void removeAuthorizableId() throws Exception {
  try {
    Tree userTree=root.getTree(userPath);
    userTree.removeProperty(REP_AUTHORIZABLE_ID);
    root.commit();
    fail("removing authorizable id should fail");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
