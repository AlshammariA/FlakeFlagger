@Test public void testGetVersionHistory() throws Exception {
  Tree vs=getTestRoot().getTree(vhPath);
  assertFalse(vs.exists());
}
