@Test public void changeAuthorizableId() throws Exception {
  try {
    Tree userTree=root.getTree(userPath);
    userTree.setProperty(REP_AUTHORIZABLE_ID,"modified");
    root.commit();
    fail("changing the authorizable id should fail");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    root.refresh();
  }
}
