@Test public void testEquals(){
  final CacheKey key1=new CacheKey("g1",ResourceType.JS,true);
  final CacheKey key2=new CacheKey("g1",ResourceType.JS,true);
  assertEquals(key1,key2);
}
