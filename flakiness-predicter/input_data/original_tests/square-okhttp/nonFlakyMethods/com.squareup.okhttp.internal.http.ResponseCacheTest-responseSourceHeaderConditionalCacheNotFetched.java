@Test public void responseSourceHeaderConditionalCacheNotFetched() throws IOException {
  server.enqueue(new MockResponse().setBody("A").addHeader("Cache-Control: max-age=0").addHeader("Date: " + formatDate(0,TimeUnit.MINUTES)));
  server.enqueue(new MockResponse().setResponseCode(304));
  server.play();
  assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
  HttpURLConnection connection=openConnection(server.getUrl("/"));
  assertEquals("A",readAscii(connection));
  String source=connection.getHeaderField(OkHeaders.RESPONSE_SOURCE);
  assertEquals(ResponseSource.CONDITIONAL_CACHE + " 304",source);
}
