@Test public void gzipAndConnectionReuseWithFixedLength() throws Exception {
  testClientConfiguredGzipContentEncodingAndConnectionReuse(TransferKind.FIXED_LENGTH,false);
}
