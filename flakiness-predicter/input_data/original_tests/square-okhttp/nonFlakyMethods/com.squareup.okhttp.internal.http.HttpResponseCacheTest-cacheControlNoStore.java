@Test public void cacheControlNoStore() throws Exception {
  assertNotCached(new MockResponse().addHeader("Cache-Control: no-store"));
}
