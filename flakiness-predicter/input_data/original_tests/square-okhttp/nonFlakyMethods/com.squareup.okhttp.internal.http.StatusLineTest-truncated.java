@Test public void truncated() throws IOException {
  assertInvalid("");
  assertInvalid("H");
  assertInvalid("HTTP/1");
  assertInvalid("HTTP/1.");
  assertInvalid("HTTP/1.1");
  assertInvalid("HTTP/1.1 ");
  assertInvalid("HTTP/1.1 2");
  assertInvalid("HTTP/1.1 20");
}
