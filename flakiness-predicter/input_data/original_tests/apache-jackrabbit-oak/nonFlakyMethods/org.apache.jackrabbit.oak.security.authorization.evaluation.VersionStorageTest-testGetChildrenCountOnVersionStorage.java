@Test public void testGetChildrenCountOnVersionStorage() throws Exception {
  Tree vs=getTestRoot().getTree(VersionConstants.VERSION_STORE_PATH);
  vs.getChildrenCount(Long.MAX_VALUE);
}
