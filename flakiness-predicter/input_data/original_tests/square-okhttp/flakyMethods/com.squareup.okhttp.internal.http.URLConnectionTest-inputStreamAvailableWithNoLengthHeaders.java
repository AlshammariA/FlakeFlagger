@Test public void inputStreamAvailableWithNoLengthHeaders() throws Exception {
  testInputStreamAvailable(TransferKind.END_OF_STREAM);
}
