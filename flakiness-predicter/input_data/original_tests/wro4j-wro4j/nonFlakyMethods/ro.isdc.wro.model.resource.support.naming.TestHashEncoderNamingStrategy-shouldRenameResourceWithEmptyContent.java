@Test public void shouldRenameResourceWithEmptyContent() throws Exception {
  final String result=namingStrategy.rename("fileName",WroUtil.EMPTY_STREAM);
  assertEquals("fileName-0",result);
}
