@Test public void testNormalize_withThisAndParentDirNames(){
  assertNormalizedPathEquals("foo/test","foo/./bar/../././baz/../test");
}
