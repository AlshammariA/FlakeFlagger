@Test public void redirectedWithNoLengthHeaders() throws Exception {
  testRedirected(TransferKind.END_OF_STREAM,false);
}
