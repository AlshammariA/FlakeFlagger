@Test public void wrongMessageDelimiter() throws IOException {
  assertInvalid("HTTP/1.1 200_");
}
