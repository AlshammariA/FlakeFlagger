@Test public void earlyDisconnectDoesntHarmPoolingWithChunkedEncoding() throws Exception {
  testEarlyDisconnectDoesntHarmPooling(TransferKind.CHUNKED);
}
