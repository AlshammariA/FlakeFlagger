@Test public void cachePlusRange() throws Exception {
  assertNotCached(new MockResponse().setResponseCode(HttpURLConnection.HTTP_PARTIAL).addHeader("Date: " + formatDate(0,TimeUnit.HOURS)).addHeader("Content-Range: bytes 100-100/200").addHeader("Cache-Control: max-age=60"));
}
