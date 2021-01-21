@Test public void getKeepAlive() throws Exception {
  MockWebServer server=new MockWebServer();
  server.enqueue(new MockResponse().setBody("ABC"));
  server.play();
  HttpURLConnection connection1=client.open(server.getUrl(""));
  connection1.setReadTimeout(100);
  InputStream input=connection1.getInputStream();
  assertEquals("ABC",readAscii(input,Integer.MAX_VALUE));
  server.shutdown();
  try {
    HttpURLConnection connection2=client.open(server.getUrl(""));
    connection2.setReadTimeout(100);
    connection2.getInputStream();
    fail();
  }
 catch (  ConnectException expected) {
  }
}
