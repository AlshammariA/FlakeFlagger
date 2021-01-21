@Test public void urlContainsQueryButNoPath() throws Exception {
  server.enqueue(new MockResponse().setBody("A"));
  server.play();
  URL url=new URL("http",server.getHostName(),server.getPort(),"?query");
  assertEquals("A",readAscii(client.open(url).getInputStream(),Integer.MAX_VALUE));
  RecordedRequest request=server.takeRequest();
  assertEquals("GET /?query HTTP/1.1",request.getRequestLine());
}
