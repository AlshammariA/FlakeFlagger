@Test public void responseCachingAndInputStreamSkipWithChunkedEncoding() throws IOException {
  testResponseCaching(TransferKind.CHUNKED);
}
