@Test public void testPathWithExtraSlashes(){
  assertPathEquals("/foo/bar/baz",fs.getPath("/foo/bar/baz/"));
  assertPathEquals("/foo/bar/baz",fs.getPath("/foo//bar///baz"));
  assertPathEquals("/foo/bar/baz",fs.getPath("///foo/bar/baz"));
}
