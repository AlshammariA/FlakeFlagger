@Test public void inputStreamAvailableWithContentLengthHeader() throws Exception {
  testInputStreamAvailable(TransferKind.FIXED_LENGTH);
}
