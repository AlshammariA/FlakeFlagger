@Test public void clientPrematureDisconnectWithNoLengthHeaders() throws IOException {
  testClientPrematureDisconnect(TransferKind.END_OF_STREAM);
}
