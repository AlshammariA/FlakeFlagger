@Test public void flushAfterStreamTransmittedWithChunkedEncoding() throws IOException {
  testFlushAfterStreamTransmitted(TransferKind.CHUNKED);
}
