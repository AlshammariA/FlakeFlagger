@Test public void cacheControlNoStoreAndExpirationDateInTheFuture() throws Exception {
  assertNotCached(new MockResponse().addHeader("Last-Modified: " + formatDate(-2,TimeUnit.HOURS)).addHeader("Expires: " + formatDate(1,TimeUnit.HOURS)).addHeader("Cache-Control: no-store"));
}
