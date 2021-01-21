@Test public void doesNotFollow21Redirects() throws Exception {
  for (int i=0; i < 21; i++) {
    server.enqueue(new MockResponse().setResponseCode(301).addHeader("Location: /" + (i + 1)).setBody("Redirecting to /" + (i + 1)));
  }
  server.play();
  Request request=new Request.Builder().url(server.getUrl("/0")).build();
  client.enqueue(request,receiver);
  receiver.await(server.getUrl("/20")).assertFailure("Too many redirects: 21");
}
