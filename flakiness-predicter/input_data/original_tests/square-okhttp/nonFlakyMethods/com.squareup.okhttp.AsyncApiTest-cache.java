@Test public void cache() throws Exception {
  server.enqueue(new MockResponse().setBody("A").addHeader("ETag: v1"));
  server.enqueue(new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_MODIFIED));
  server.play();
  client.setOkResponseCache(cache);
  Request request1=new Request.Builder().url(server.getUrl("/")).build();
  client.enqueue(request1,receiver);
  receiver.await(request1.url()).assertCode(200).assertBody("A");
  assertNull(server.takeRequest().getHeader("If-None-Match"));
  Request request2=new Request.Builder().url(server.getUrl("/")).build();
  client.enqueue(request2,receiver);
  receiver.await(request2.url()).assertCode(200).assertBody("A");
  assertEquals("v1",server.takeRequest().getHeader("If-None-Match"));
}
