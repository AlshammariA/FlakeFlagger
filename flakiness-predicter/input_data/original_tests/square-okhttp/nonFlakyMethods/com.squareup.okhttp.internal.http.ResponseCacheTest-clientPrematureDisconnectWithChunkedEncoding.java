@Test public void clientPrematureDisconnectWithChunkedEncoding() throws IOException {
  testClientPrematureDisconnect(TransferKind.CHUNKED);
}
