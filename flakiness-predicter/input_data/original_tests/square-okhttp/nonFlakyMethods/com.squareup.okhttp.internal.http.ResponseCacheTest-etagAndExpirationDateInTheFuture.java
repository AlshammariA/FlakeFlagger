@Test public void etagAndExpirationDateInTheFuture() throws Exception {
  assertFullyCached(new MockResponse().addHeader("ETag: v1").addHeader("Last-Modified: " + formatDate(-2,TimeUnit.HOURS)).addHeader("Expires: " + formatDate(1,TimeUnit.HOURS)));
}
