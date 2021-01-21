@Test public void get() throws Exception {
  server.enqueue(new MockResponse().setBody("abc").addHeader("Content-Type: text/plain"));
  server.play();
  Request request=new Request.Builder().url(server.getUrl("/")).header("User-Agent","AsyncApiTest").build();
  client.enqueue(request,receiver);
  receiver.await(request.url()).assertCode(200).assertContainsHeaders("Content-Type: text/plain").assertBody("abc");
  assertTrue(server.takeRequest().getHeaders().contains("User-Agent: AsyncApiTest"));
}
