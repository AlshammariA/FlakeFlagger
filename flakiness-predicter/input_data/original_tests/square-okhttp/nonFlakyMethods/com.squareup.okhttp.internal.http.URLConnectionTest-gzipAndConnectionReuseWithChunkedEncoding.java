@Test public void gzipAndConnectionReuseWithChunkedEncoding() throws Exception {
  testClientConfiguredGzipContentEncodingAndConnectionReuse(TransferKind.CHUNKED,false);
}
