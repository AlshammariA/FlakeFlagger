@Test public void markAndResetWithNoLengthHeaders() throws IOException {
  testMarkAndReset(TransferKind.END_OF_STREAM);
}
