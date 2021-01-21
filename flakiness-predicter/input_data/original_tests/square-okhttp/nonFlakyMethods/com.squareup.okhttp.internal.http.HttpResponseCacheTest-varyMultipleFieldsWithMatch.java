@Test public void varyMultipleFieldsWithMatch() throws Exception {
  server.enqueue(new MockResponse().addHeader("Cache-Control: max-age=60").addHeader("Vary: Accept-Language, Accept-Charset").addHeader("Vary: Accept-Encoding").setBody("A"));
  server.enqueue(new MockResponse().setBody("B"));
  server.play();
  URL url=server.getUrl("/");
  URLConnection connection1=openConnection(url);
  connection1.addRequestProperty("Accept-Language","fr-CA");
  connection1.addRequestProperty("Accept-Charset","UTF-8");
  connection1.addRequestProperty("Accept-Encoding","identity");
  assertEquals("A",readAscii(connection1));
  URLConnection connection2=openConnection(url);
  connection2.addRequestProperty("Accept-Language","fr-CA");
  connection2.addRequestProperty("Accept-Charset","UTF-8");
  connection2.addRequestProperty("Accept-Encoding","identity");
  assertEquals("A",readAscii(connection2));
}
