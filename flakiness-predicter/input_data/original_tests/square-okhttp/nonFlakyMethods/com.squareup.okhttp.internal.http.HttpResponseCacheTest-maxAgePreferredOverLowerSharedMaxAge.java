@Test public void maxAgePreferredOverLowerSharedMaxAge() throws Exception {
  assertFullyCached(new MockResponse().addHeader("Date: " + formatDate(-2,TimeUnit.MINUTES)).addHeader("Cache-Control: s-maxage=60").addHeader("Cache-Control: max-age=180"));
}
