@Test public void testNormalize_withParentDirName(){
  assertNormalizedPathEquals("/foo/baz","/foo/bar/../baz");
  assertNormalizedPathEquals("/foo/baz","/foo","bar","..","baz");
}
