@Test public void maxAgePreferredWithMaxAgeAndExpires() throws Exception {
  assertFullyCached(new MockResponse().addHeader("Date: " + formatDate(0,TimeUnit.HOURS)).addHeader("Expires: " + formatDate(-1,TimeUnit.HOURS)).addHeader("Cache-Control: max-age=60"));
}
