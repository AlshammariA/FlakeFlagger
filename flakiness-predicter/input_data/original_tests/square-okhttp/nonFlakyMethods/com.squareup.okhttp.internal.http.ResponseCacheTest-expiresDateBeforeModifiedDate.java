@Test public void expiresDateBeforeModifiedDate() throws Exception {
  assertConditionallyCached(new MockResponse().addHeader("Last-Modified: " + formatDate(-1,TimeUnit.HOURS)).addHeader("Expires: " + formatDate(-2,TimeUnit.HOURS)));
}
