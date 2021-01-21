@Test public void testRelativize_bothAbsolute(){
  assertRelativizedPathEquals("b/c",fs.getPath("/a"),"/a/b/c");
  assertRelativizedPathEquals("c/d",fs.getPath("/a/b"),"/a/b/c/d");
}
