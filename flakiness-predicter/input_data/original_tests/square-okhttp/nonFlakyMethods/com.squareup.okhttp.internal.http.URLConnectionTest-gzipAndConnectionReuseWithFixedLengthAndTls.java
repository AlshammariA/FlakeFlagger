@Test public void gzipAndConnectionReuseWithFixedLengthAndTls() throws Exception {
  testClientConfiguredGzipContentEncodingAndConnectionReuse(TransferKind.FIXED_LENGTH,true);
}
