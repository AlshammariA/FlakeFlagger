@Test public void testNewFileSystem_hasRootAndWorkingDirectory() throws IOException {
  assertThat("/").hasChildren("work");
  assertThat("/work").hasNoChildren();
}
