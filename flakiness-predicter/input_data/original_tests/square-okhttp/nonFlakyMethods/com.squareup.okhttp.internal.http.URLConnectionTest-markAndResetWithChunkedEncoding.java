@Test public void markAndResetWithChunkedEncoding() throws IOException {
  testMarkAndReset(TransferKind.CHUNKED);
}
