@Test public void testNormalize_withLeadingThisAndParentDirNames(){
  assertNormalizedPathEquals("../../foo/baz","./.././.././foo/bar/../baz");
}
