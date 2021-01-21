@Test public void pragmaNoCacheAndExpirationDateInTheFuture() throws Exception {
  String lastModifiedDate=formatDate(-2,TimeUnit.HOURS);
  RecordedRequest conditionalRequest=assertConditionallyCached(new MockResponse().addHeader("Last-Modified: " + lastModifiedDate).addHeader("Expires: " + formatDate(1,TimeUnit.HOURS)).addHeader("Pragma: no-cache"));
  List<String> headers=conditionalRequest.getHeaders();
  assertTrue(headers.contains("If-Modified-Since: " + lastModifiedDate));
}
