@Test public void missingProtocol() throws IOException {
  assertInvalid("");
  assertInvalid(" ");
  assertInvalid("200 OK");
  assertInvalid(" 200 OK");
}
