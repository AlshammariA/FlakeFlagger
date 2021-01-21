@Test public void varyMatchesRemovedRequestHeaderField() throws Exception {
  server.enqueue(new MockResponse().addHeader("Cache-Control: max-age=60").addHeader("Vary: Foo").setBody("A"));
  server.enqueue(new MockResponse().setBody("B"));
  server.play();
  URLConnection fooConnection=openConnection(server.getUrl("/"));
  fooConnection.addRequestProperty("Foo","bar");
  assertEquals("A",readAscii(fooConnection));
  assertEquals("B",readAscii(openConnection(server.getUrl("/"))));
}
