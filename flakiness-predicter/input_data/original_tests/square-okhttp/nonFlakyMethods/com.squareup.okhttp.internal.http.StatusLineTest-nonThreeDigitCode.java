@Test public void nonThreeDigitCode() throws IOException {
  assertInvalid("HTTP/1.1  OK");
  assertInvalid("HTTP/1.1 2 OK");
  assertInvalid("HTTP/1.1 20 OK");
  assertInvalid("HTTP/1.1 2000 OK");
  assertInvalid("HTTP/1.1 two OK");
  assertInvalid("HTTP/1.1 2");
  assertInvalid("HTTP/1.1 2000");
  assertInvalid("HTTP/1.1 two");
}
