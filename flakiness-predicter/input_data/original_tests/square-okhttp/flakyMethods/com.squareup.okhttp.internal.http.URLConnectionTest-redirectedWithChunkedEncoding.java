@Test public void redirectedWithChunkedEncoding() throws Exception {
  testRedirected(TransferKind.CHUNKED,true);
}
