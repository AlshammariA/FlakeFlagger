@Test public void pathDepth(){
  assertEquals(0,Utils.pathDepth(""));
  assertEquals(0,Utils.pathDepth("/"));
  assertEquals(1,Utils.pathDepth("1/"));
  assertEquals(2,Utils.pathDepth("/a/"));
  assertEquals(2,Utils.pathDepth("/a/b"));
  assertEquals(3,Utils.pathDepth("/a/b/c"));
}
