@Test public void testPathParsing_withExtraSeparators(){
  assertPathEquals("/foo/bar","///foo/bar");
  assertPathEquals("/foo/bar","/foo///bar//");
  assertPathEquals("/foo/bar/baz","/foo","/bar","baz/");
}
