@Test public void serverDisconnectsPrematurelyWithContentLengthHeader() throws IOException {
  testServerPrematureDisconnect(TransferKind.FIXED_LENGTH);
}
