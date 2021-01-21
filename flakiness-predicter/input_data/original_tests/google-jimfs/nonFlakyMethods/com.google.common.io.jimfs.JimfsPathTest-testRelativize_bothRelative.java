@Test public void testRelativize_bothRelative(){
  assertRelativizedPathEquals("b/c",fs.getPath("a"),"a/b/c");
  assertRelativizedPathEquals("d",fs.getPath("a/b/c"),"a/b/c/d");
}
