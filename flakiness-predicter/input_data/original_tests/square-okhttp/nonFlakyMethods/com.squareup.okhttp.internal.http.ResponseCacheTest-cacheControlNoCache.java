@Test public void cacheControlNoCache() throws Exception {
  assertNotCached(new MockResponse().addHeader("Cache-Control: no-cache"));
}
