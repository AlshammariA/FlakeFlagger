@Test public void markAndResetWithContentLengthHeader() throws IOException {
  testMarkAndReset(TransferKind.FIXED_LENGTH);
}
