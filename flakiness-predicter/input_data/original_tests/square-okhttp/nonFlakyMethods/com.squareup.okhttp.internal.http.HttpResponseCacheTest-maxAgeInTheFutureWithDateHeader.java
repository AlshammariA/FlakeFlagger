@Test public void maxAgeInTheFutureWithDateHeader() throws Exception {
  assertFullyCached(new MockResponse().addHeader("Date: " + formatDate(0,TimeUnit.HOURS)).addHeader("Cache-Control: max-age=60"));
}
