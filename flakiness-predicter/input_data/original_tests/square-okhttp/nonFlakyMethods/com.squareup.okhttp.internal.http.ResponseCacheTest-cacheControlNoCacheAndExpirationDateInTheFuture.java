@Test public void cacheControlNoCacheAndExpirationDateInTheFuture() throws Exception {
  String lastModifiedDate=formatDate(-2,TimeUnit.HOURS);
  RecordedRequest conditionalRequest=assertConditionallyCached(new MockResponse().addHeader("Last-Modified: " + lastModifiedDate).addHeader("Expires: " + formatDate(1,TimeUnit.HOURS)).addHeader("Cache-Control: no-cache"));
  List<String> headers=conditionalRequest.getHeaders();
  assertTrue(headers.contains("If-Modified-Since: " + lastModifiedDate));
}
