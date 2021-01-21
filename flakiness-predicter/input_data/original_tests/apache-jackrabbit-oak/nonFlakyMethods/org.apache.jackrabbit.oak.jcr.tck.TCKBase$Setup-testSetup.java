public void testSetup() throws Exception {
  RepositoryHelperPool helperPool=RepositoryHelperPoolImpl.getInstance();
  previous.addAll(Arrays.asList(helperPool.borrowHelpers()));
  helperPool.returnHelper(getRepositoryHelper());
}
