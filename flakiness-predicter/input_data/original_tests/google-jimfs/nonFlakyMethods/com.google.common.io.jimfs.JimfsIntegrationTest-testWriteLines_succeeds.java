@Test public void testWriteLines_succeeds() throws IOException {
  Files.write(path("/test.txt"),ImmutableList.of("hello","world"),UTF_8);
}
