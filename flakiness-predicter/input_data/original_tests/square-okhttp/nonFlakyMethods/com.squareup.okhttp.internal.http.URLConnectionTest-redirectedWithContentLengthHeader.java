@Test public void redirectedWithContentLengthHeader() throws Exception {
  testRedirected(TransferKind.FIXED_LENGTH,true);
}
