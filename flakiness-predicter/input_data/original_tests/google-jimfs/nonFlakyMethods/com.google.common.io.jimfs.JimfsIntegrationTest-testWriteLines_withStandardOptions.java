@Test public void testWriteLines_withStandardOptions() throws IOException {
  Path test=path("/test.txt");
  ImmutableList<String> lines=ImmutableList.of("hello","world");
  try {
    Files.write(test,lines,UTF_8,WRITE);
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals(test.toString(),expected.getMessage());
  }
  Files.write(test,lines,UTF_8,CREATE_NEW);
  assertThat(test).containsLines(lines);
  try {
    Files.write(test,lines,UTF_8,CREATE_NEW);
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
  }
  Files.write(test,ImmutableList.of("foo"),UTF_8,CREATE);
  assertThat(test).containsLines("foo","o","world");
  Files.write(test,lines,UTF_8,WRITE,CREATE,TRUNCATE_EXISTING);
  assertThat(test).containsLines(lines);
  Files.write(test,lines,UTF_8,WRITE,APPEND);
  assertThat(test).containsLines("hello","world","hello","world");
  Files.write(test,lines,UTF_8,WRITE,CREATE,TRUNCATE_EXISTING,APPEND,SPARSE,DSYNC,SYNC);
  assertThat(test).containsLines(lines);
  try {
    Files.write(test,lines,UTF_8,READ,WRITE);
    fail();
  }
 catch (  UnsupportedOperationException expected) {
  }
}
