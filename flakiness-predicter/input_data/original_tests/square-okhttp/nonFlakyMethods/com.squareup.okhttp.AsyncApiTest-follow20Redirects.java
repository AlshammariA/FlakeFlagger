@Test public void follow20Redirects() throws Exception {
  for (int i=0; i < 20; i++) {
    server.enqueue(new MockResponse().setResponseCode(301).addHeader("Location: /" + (i + 1)).setBody("Redirecting to /" + (i + 1)));
  }
  server.enqueue(new MockResponse().setBody("Success!"));
  server.play();
  Request request=new Request.Builder().url(server.getUrl("/0")).build();
  client.enqueue(request,receiver);
  receiver.await(server.getUrl("/20")).assertCode(200).assertBody("Success!");
}
