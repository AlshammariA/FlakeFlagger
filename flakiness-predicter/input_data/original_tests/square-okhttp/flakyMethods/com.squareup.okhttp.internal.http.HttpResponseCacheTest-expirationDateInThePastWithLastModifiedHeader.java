@Test public void expirationDateInThePastWithLastModifiedHeader() throws Exception {
  String lastModifiedDate=formatDate(-2,TimeUnit.HOURS);
  RecordedRequest conditionalRequest=assertConditionallyCached(new MockResponse().addHeader("Last-Modified: " + lastModifiedDate).addHeader("Expires: " + formatDate(-1,TimeUnit.HOURS)));
  List<String> headers=conditionalRequest.getHeaders();
  assertTrue(headers.contains("If-Modified-Since: " + lastModifiedDate));
}
