@Test public void testRead_forFileAfterWriteLines_isLinesWritten() throws IOException {
  Files.write(path("/test.txt"),ImmutableList.of("hello","world"),UTF_8);
  assertThat("/test.txt").containsLines("hello","world");
}
