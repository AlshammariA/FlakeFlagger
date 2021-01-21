@Test public void testGetChildrenCount() throws Exception {
  long cntRoot=root.getTree("/").getChildrenCount(Long.MAX_VALUE);
  long cntA=root.getTree("/a").getChildrenCount(Long.MAX_VALUE);
  assertEquals(cntRoot - 1,testRoot.getTree("/").getChildrenCount(Long.MAX_VALUE));
  assertEquals(cntA - 1,testRoot.getTree("/a").getChildrenCount(Long.MAX_VALUE));
  List<String> paths=ImmutableList.of("/a/b","/a/b/c");
  for (  String path : paths) {
    assertEquals(root.getTree(path).getChildrenCount(Long.MAX_VALUE),testRoot.getTree(path).getChildrenCount(Long.MAX_VALUE));
  }
}
