@Test public void post() throws Exception {
  server.enqueue(new MockResponse().setBody("abc"));
  server.play();
  Request request=new Request.Builder().url(server.getUrl("/")).post(Request.Body.create(MediaType.parse("text/plain"),"def")).build();
  client.enqueue(request,receiver);
  receiver.await(request.url()).assertCode(200).assertBody("abc");
  RecordedRequest recordedRequest=server.takeRequest();
  assertEquals("def",recordedRequest.getUtf8Body());
  assertEquals("3",recordedRequest.getHeader("Content-Length"));
  assertEquals("text/plain; charset=utf-8",recordedRequest.getHeader("Content-Type"));
}
