@Test public void connectionPooling() throws Exception {
  server.enqueue(new MockResponse().setBody("abc"));
  server.enqueue(new MockResponse().setBody("def"));
  server.enqueue(new MockResponse().setBody("ghi"));
  server.play();
  client.enqueue(new Request.Builder().url(server.getUrl("/a")).build(),receiver);
  receiver.await(server.getUrl("/a")).assertBody("abc");
  client.enqueue(new Request.Builder().url(server.getUrl("/b")).build(),receiver);
  receiver.await(server.getUrl("/b")).assertBody("def");
  client.enqueue(new Request.Builder().url(server.getUrl("/c")).build(),receiver);
  receiver.await(server.getUrl("/c")).assertBody("ghi");
  assertEquals(0,server.takeRequest().getSequenceNumber());
  assertEquals(1,server.takeRequest().getSequenceNumber());
  assertEquals(2,server.takeRequest().getSequenceNumber());
}
