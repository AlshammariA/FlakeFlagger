@Test public void clientPrematureDisconnectWithContentLengthHeader() throws IOException {
  testClientPrematureDisconnect(TransferKind.FIXED_LENGTH);
}
