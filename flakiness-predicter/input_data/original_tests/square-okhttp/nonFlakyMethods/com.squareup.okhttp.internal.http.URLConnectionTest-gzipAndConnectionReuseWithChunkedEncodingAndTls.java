@Test public void gzipAndConnectionReuseWithChunkedEncodingAndTls() throws Exception {
  testClientConfiguredGzipContentEncodingAndConnectionReuse(TransferKind.CHUNKED,true);
}
