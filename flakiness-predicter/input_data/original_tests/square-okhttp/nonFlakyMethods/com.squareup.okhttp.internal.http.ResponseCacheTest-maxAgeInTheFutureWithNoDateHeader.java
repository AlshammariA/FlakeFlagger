@Test public void maxAgeInTheFutureWithNoDateHeader() throws Exception {
  assertFullyCached(new MockResponse().addHeader("Cache-Control: max-age=60"));
}
