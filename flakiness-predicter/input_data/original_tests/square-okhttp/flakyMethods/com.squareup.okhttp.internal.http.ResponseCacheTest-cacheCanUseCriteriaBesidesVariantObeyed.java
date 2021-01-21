/** 
 * Confirms the cache implementation may determine the criteria for caching. In real caches this would be the "Vary" headers.
 */
@Test public void cacheCanUseCriteriaBesidesVariantObeyed() throws Exception {
  server.enqueue(new MockResponse().addHeader("Cache-Control: max-age=60").addHeader(InMemoryResponseCache.CACHE_VARIANT_HEADER,"A").setBody("A"));
  server.enqueue(new MockResponse().addHeader("Cache-Control: max-age=60").addHeader(InMemoryResponseCache.CACHE_VARIANT_HEADER,"B").setBody("B"));
  server.play();
  URL url=server.getUrl("/");
  URLConnection connection1=openConnection(url);
  connection1.addRequestProperty(InMemoryResponseCache.CACHE_VARIANT_HEADER,"A");
  assertEquals("A",readAscii(connection1));
  URLConnection connection2=openConnection(url);
  connection2.addRequestProperty(InMemoryResponseCache.CACHE_VARIANT_HEADER,"A");
  assertEquals("A",readAscii(connection2));
  assertEquals(1,server.getRequestCount());
  URLConnection connection3=openConnection(url);
  connection3.addRequestProperty(InMemoryResponseCache.CACHE_VARIANT_HEADER,"B");
  assertEquals("B",readAscii(connection3));
  assertEquals(2,server.getRequestCount());
  URLConnection connection4=openConnection(url);
  connection4.addRequestProperty(InMemoryResponseCache.CACHE_VARIANT_HEADER,"A");
  assertEquals("A",readAscii(connection4));
  assertEquals(2,server.getRequestCount());
}
