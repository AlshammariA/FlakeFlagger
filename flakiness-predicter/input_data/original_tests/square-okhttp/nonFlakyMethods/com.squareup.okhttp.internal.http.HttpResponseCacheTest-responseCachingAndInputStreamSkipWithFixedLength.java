@Test public void responseCachingAndInputStreamSkipWithFixedLength() throws IOException {
  testResponseCaching(TransferKind.FIXED_LENGTH);
}
