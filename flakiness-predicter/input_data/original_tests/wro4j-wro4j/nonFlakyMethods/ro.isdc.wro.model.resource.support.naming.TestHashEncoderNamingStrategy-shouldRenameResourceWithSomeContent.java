@Test public void shouldRenameResourceWithSomeContent() throws Exception {
  final String result=namingStrategy.rename("anotherFile.js",new ByteArrayInputStream("someContent".getBytes()));
  assertEquals("anotherFile-b598c484.js",result);
}
