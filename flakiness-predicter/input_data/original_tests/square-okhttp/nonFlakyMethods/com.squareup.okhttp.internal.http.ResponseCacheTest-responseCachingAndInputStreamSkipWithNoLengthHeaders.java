@Test public void responseCachingAndInputStreamSkipWithNoLengthHeaders() throws IOException {
  testResponseCaching(TransferKind.END_OF_STREAM);
}
