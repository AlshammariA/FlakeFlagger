@Test public void testGetVersionStorage() throws Exception {
  Tree vs=getTestRoot().getTree(VersionConstants.VERSION_STORE_PATH);
  assertFalse(vs.exists());
}
