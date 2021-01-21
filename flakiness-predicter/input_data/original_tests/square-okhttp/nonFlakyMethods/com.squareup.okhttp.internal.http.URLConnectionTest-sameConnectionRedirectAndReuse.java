/** 
 * Retry redirects if the socket is closed. https://code.google.com/p/android/issues/detail?id=41576
 */
@Test public void sameConnectionRedirectAndReuse() throws Exception {
  server.enqueue(new MockResponse().setResponseCode(HttpURLConnection.HTTP_MOVED_TEMP).setSocketPolicy(SHUTDOWN_INPUT_AT_END).addHeader("Location: /foo"));
  server.enqueue(new MockResponse().setBody("This is the new page!"));
  server.play();
  assertContent("This is the new page!",client.open(server.getUrl("/")));
  assertEquals(0,server.takeRequest().getSequenceNumber());
  assertEquals(0,server.takeRequest().getSequenceNumber());
}
