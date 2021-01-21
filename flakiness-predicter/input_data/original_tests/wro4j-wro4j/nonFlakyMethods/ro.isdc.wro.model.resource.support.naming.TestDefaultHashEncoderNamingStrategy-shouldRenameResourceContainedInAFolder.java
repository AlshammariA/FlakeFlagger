@Test public void shouldRenameResourceContainedInAFolder() throws Exception {
  final String result=namingStrategy.rename("folder1/folder2/resource.css",new ByteArrayInputStream("someContent".getBytes()));
  assertEquals("folder1/folder2/resource-99ef8ae827896f2af4032d5dab9298ec86309abf.css",result);
}
