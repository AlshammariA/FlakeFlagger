@Test public void nonIdentityEncodingAndFullCache() throws Exception {
  assertNonIdentityEncodingCached(new MockResponse().addHeader("Last-Modified: " + formatDate(-2,TimeUnit.HOURS)).addHeader("Expires: " + formatDate(1,TimeUnit.HOURS)));
}
