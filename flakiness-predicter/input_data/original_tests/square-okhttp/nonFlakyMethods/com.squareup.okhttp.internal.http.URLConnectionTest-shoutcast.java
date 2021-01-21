@Test public void shoutcast() throws Exception {
  server.enqueue(new MockResponse().setStatus("ICY 200 OK").addHeader("Accept-Ranges: none").addHeader("Content-Type: audio/mpeg").addHeader("icy-br:128").addHeader("ice-audio-info: bitrate=128;samplerate=44100;channels=2").addHeader("icy-br:128").addHeader("icy-description:Rock").addHeader("icy-genre:riders").addHeader("icy-name:A2RRock").addHeader("icy-pub:1").addHeader("icy-url:http://www.A2Rradio.com").addHeader("Server: Icecast 2.3.3-kh8").addHeader("Cache-Control: no-cache").addHeader("Pragma: no-cache").addHeader("Expires: Mon, 26 Jul 1997 05:00:00 GMT").addHeader("icy-metaint:16000").setBody("mp3 data"));
  server.play();
  connection=client.open(server.getUrl("/"));
  assertEquals(200,connection.getResponseCode());
  assertEquals("OK",connection.getResponseMessage());
  assertContent("mp3 data",connection);
}
