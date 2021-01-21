/** 
 * We had a bug where we attempted to gunzip responses that didn't have a body. This only came up with 304s since that response code can include headers (like "Content-Encoding") without any content to go along with it. https://github.com/square/okhttp/issues/358
 */
@Test public void noTransparentGzipFor304NotModified() throws Exception {
  server.enqueue(new MockResponse().clearHeaders().setResponseCode(HttpURLConnection.HTTP_NOT_MODIFIED).addHeader("Content-Encoding: gzip"));
  server.enqueue(new MockResponse().setBody("b"));
  server.play();
  HttpURLConnection connection1=client.open(server.getUrl("/"));
  assertEquals(HttpURLConnection.HTTP_NOT_MODIFIED,connection1.getResponseCode());
  assertContent("",connection1);
  HttpURLConnection connection2=client.open(server.getUrl("/"));
  assertEquals(HttpURLConnection.HTTP_OK,connection2.getResponseCode());
  assertContent("b",connection2);
  RecordedRequest requestA=server.takeRequest();
  assertEquals(0,requestA.getSequenceNumber());
  RecordedRequest requestB=server.takeRequest();
  assertEquals(1,requestB.getSequenceNumber());
}
