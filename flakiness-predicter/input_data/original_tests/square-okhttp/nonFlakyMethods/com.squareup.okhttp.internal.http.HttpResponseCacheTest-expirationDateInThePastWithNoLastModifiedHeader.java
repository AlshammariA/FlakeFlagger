@Test public void expirationDateInThePastWithNoLastModifiedHeader() throws Exception {
  assertNotCached(new MockResponse().addHeader("Expires: " + formatDate(-1,TimeUnit.HOURS)));
}
