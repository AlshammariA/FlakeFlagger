@Test public void testTrailingSlash(){
  assertEquals("/oak-foo:bar/oak-quu:qux",npMapper.getOakPath("/foo:bar/quu:qux/"));
  assertEquals("/a/b/c",npMapper.getOakPath("/a/b/c/"));
}
