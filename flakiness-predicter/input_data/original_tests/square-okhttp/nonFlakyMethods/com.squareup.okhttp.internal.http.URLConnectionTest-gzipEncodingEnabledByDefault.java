/** 
 * This test checks whether connections are gzipped by default. This behavior in not required by the API, so a failure of this test does not imply a bug in the implementation.
 */
@Test public void gzipEncodingEnabledByDefault() throws IOException, InterruptedException {
  server.enqueue(new MockResponse().setBody(gzip("ABCABCABC".getBytes("UTF-8"))).addHeader("Content-Encoding: gzip"));
  server.play();
  URLConnection connection=client.open(server.getUrl("/"));
  assertEquals("ABCABCABC",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
  assertNull(connection.getContentEncoding());
  assertEquals(-1,connection.getContentLength());
  RecordedRequest request=server.takeRequest();
  assertContains(request.getHeaders(),"Accept-Encoding: gzip");
}
