@Test public void shouldRenameResourceContainedInAFolder() throws Exception {
  final String result=namingStrategy.rename("folder1/folder2/resource.css",new ByteArrayInputStream("someContent".getBytes()));
  assertEquals("folder1/folder2/resource-b598c484.css",result);
}
