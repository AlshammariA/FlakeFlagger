@Test public void earlyDisconnectDoesntHarmPoolingWithFixedLengthEncoding() throws Exception {
  testEarlyDisconnectDoesntHarmPooling(TransferKind.FIXED_LENGTH);
}
