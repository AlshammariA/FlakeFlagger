public void testTearDown() throws Exception {
  RepositoryHelperPool helperPool=RepositoryHelperPoolImpl.getInstance();
  helperPool.borrowHelpers();
  for (  RepositoryHelper helper : helpers) {
    helperPool.returnHelper(helper);
  }
}
