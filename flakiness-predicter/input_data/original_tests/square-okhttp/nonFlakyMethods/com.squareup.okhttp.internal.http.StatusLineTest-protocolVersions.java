@Test public void protocolVersions() throws IOException {
  assertInvalid("HTTP/2.0 200 OK");
  assertInvalid("HTTP/2.1 200 OK");
  assertInvalid("HTTP/-.1 200 OK");
  assertInvalid("HTTP/1.- 200 OK");
  assertInvalid("HTTP/0.1 200 OK");
  assertInvalid("HTTP/101 200 OK");
  assertInvalid("HTTP/1.1_200 OK");
}
