@Test public void maxAgeWithLastModifiedButNoServedDate() throws Exception {
  assertFullyCached(new MockResponse().addHeader("Last-Modified: " + formatDate(-120,TimeUnit.SECONDS)).addHeader("Cache-Control: max-age=60"));
}
