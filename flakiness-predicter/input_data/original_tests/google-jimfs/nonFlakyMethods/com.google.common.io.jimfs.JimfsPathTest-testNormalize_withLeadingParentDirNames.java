@Test public void testNormalize_withLeadingParentDirNames(){
  assertNormalizedPathEquals("../../foo/baz","../../foo/bar/../baz");
}
