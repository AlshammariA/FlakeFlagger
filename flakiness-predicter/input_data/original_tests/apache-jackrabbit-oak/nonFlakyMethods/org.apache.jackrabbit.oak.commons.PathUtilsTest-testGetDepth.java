@Test public void testGetDepth(){
  assertEquals(0,PathUtils.getDepth("/"));
  assertEquals(0,PathUtils.getDepth(""));
  assertEquals(1,PathUtils.getDepth("/a"));
  assertEquals(1,PathUtils.getDepth("a"));
  assertEquals(2,PathUtils.getDepth("/a/b"));
  assertEquals(2,PathUtils.getDepth("a/b"));
}
