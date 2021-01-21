@Test public void testNormalize_withExtraParentDirNamesAtRoot(){
  assertNormalizedPathEquals("/","/..");
  assertNormalizedPathEquals("/","/../../..");
  assertNormalizedPathEquals("/","/foo/../../..");
  assertNormalizedPathEquals("/","/../foo/../../bar/baz/../../../..");
}
