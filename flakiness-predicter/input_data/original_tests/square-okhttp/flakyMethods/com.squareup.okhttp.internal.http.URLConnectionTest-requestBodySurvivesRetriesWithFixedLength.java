@Test public void requestBodySurvivesRetriesWithFixedLength() throws Exception {
  testRequestBodySurvivesRetries(TransferKind.FIXED_LENGTH);
}
