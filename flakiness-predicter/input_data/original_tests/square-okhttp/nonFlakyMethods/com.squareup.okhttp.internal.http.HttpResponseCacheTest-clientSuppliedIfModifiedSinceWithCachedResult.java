@Test public void clientSuppliedIfModifiedSinceWithCachedResult() throws Exception {
  MockResponse response=new MockResponse().addHeader("ETag: v3").addHeader("Cache-Control: max-age=0");
  String ifModifiedSinceDate=formatDate(-24,TimeUnit.HOURS);
  RecordedRequest request=assertClientSuppliedCondition(response,"If-Modified-Since",ifModifiedSinceDate);
  List<String> headers=request.getHeaders();
  assertTrue(headers.contains("If-Modified-Since: " + ifModifiedSinceDate));
  assertFalse(headers.contains("If-None-Match: v3"));
}
