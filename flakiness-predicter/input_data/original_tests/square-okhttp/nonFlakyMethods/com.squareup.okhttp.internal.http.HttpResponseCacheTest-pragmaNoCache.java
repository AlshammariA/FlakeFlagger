@Test public void pragmaNoCache() throws Exception {
  assertNotCached(new MockResponse().addHeader("Pragma: no-cache"));
}
