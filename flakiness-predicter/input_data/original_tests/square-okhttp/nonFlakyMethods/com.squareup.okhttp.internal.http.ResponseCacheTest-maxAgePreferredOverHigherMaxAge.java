@Test public void maxAgePreferredOverHigherMaxAge() throws Exception {
  assertNotCached(new MockResponse().addHeader("Date: " + formatDate(-2,TimeUnit.MINUTES)).addHeader("Cache-Control: s-maxage=180").addHeader("Cache-Control: max-age=60"));
}
