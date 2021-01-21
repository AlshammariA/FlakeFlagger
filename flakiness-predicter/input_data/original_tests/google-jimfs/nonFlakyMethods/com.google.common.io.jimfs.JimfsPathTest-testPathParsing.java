@Test public void testPathParsing(){
  assertPathEquals("/","/");
  assertPathEquals("/foo","/foo");
  assertPathEquals("/foo","/","foo");
  assertPathEquals("/foo/bar","/foo/bar");
  assertPathEquals("/foo/bar","/","foo","bar");
  assertPathEquals("/foo/bar","/foo","bar");
  assertPathEquals("/foo/bar","/","foo/bar");
  assertPathEquals("foo/bar/baz","foo/bar/baz");
  assertPathEquals("foo/bar/baz","foo","bar","baz");
  assertPathEquals("foo/bar/baz","foo/bar","baz");
  assertPathEquals("foo/bar/baz","foo","bar/baz");
}
