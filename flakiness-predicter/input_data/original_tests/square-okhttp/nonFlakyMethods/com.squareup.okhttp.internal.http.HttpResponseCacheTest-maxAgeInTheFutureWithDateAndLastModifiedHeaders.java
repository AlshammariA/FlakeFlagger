@Test public void maxAgeInTheFutureWithDateAndLastModifiedHeaders() throws Exception {
  assertFullyCached(new MockResponse().addHeader("Last-Modified: " + formatDate(-120,TimeUnit.SECONDS)).addHeader("Date: " + formatDate(0,TimeUnit.SECONDS)).addHeader("Cache-Control: max-age=60"));
}
