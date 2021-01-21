@Test public void testNormalize_withThisDirName(){
  assertNormalizedPathEquals("/foo/bar/baz","/foo/bar/./baz");
  assertNormalizedPathEquals("/foo/bar/baz","/foo","bar",".","baz");
}
