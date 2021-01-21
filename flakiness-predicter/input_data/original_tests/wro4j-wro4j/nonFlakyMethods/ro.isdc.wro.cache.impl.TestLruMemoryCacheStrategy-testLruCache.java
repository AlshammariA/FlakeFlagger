@Test public void testLruCache() throws IOException {
  final HashStrategy builder=new CRC32HashStrategy();
  final CacheKey key1=new CacheKey("testGroup01",ResourceType.JS,false);
  final CacheKey key2=new CacheKey("testGroup02",ResourceType.CSS,false);
  final CacheKey key3=new CacheKey("testGroup03",ResourceType.JS,false);
  final CacheKey key4=new CacheKey("testGroup04",ResourceType.CSS,false);
  final String content="var foo = 'Hello World';";
  final String hash=builder.getHash(new ByteArrayInputStream(content.getBytes()));
  cache.put(key1,CacheValue.valueOf(content,hash));
  cache.put(key2,CacheValue.valueOf(content,hash));
  cache.put(key3,CacheValue.valueOf(content,hash));
  Assert.assertNotNull(cache.get(key1));
  cache.put(key4,CacheValue.valueOf(content,hash));
  Assert.assertNull(cache.get(key2));
}
