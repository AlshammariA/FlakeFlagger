@Test public void getHeadersDeletesCached100LevelWarnings() throws Exception {
  server.enqueue(new MockResponse().addHeader("Warning: 199 test danger").addHeader("Last-Modified: " + formatDate(-1,TimeUnit.HOURS)).addHeader("Cache-Control: max-age=0").setBody("A"));
  server.enqueue(new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_MODIFIED));
  server.play();
  URLConnection connection1=openConnection(server.getUrl("/"));
  assertEquals("A",readAscii(connection1));
  assertEquals("199 test danger",connection1.getHeaderField("Warning"));
  URLConnection connection2=openConnection(server.getUrl("/"));
  assertEquals("A",readAscii(connection2));
  assertEquals(null,connection2.getHeaderField("Warning"));
}
