@Test public void requestBodySurvivesRetriesWithChunkedStreaming() throws Exception {
  testRequestBodySurvivesRetries(TransferKind.CHUNKED);
}
