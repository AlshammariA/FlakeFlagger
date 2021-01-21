@Test public void testResolve_withThisAndParentDirNames(){
  Path path=fs.getPath("/foo");
  assertResolvedPathEquals("/foo/bar/../baz",path,"bar/../baz");
  assertResolvedPathEquals("/foo/bar/../baz",path,"bar","..","baz");
  assertResolvedPathEquals("/foo/./bar/baz",path,"./bar/baz");
  assertResolvedPathEquals("/foo/./bar/baz",path,".","bar/baz");
}
