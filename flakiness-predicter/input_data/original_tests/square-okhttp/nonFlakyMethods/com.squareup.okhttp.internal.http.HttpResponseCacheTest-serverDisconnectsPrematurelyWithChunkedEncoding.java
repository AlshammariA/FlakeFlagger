@Test public void serverDisconnectsPrematurelyWithChunkedEncoding() throws IOException {
  testServerPrematureDisconnect(TransferKind.CHUNKED);
}
