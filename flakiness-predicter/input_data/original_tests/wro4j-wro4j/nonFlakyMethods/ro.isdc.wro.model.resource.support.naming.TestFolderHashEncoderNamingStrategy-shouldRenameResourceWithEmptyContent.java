@Test public void shouldRenameResourceWithEmptyContent() throws Exception {
  final String result=namingStrategy.rename("fileName",WroUtil.EMPTY_STREAM);
  assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709/fileName",result);
}
