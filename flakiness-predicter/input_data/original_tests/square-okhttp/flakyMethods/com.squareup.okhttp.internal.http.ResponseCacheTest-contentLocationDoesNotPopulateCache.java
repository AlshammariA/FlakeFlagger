@Test public void contentLocationDoesNotPopulateCache() throws Exception {
  server.enqueue(new MockResponse().addHeader("Cache-Control: max-age=60").addHeader("Content-Location: /bar").setBody("A"));
  server.enqueue(new MockResponse().setBody("B"));
  server.play();
  assertEquals("A",readAscii(openConnection(server.getUrl("/foo"))));
  assertEquals("B",readAscii(openConnection(server.getUrl("/bar"))));
}
