@Test public void testEquals2(){
  final CacheKey key1=new CacheKey("g1",ResourceType.JS,false);
  final CacheKey key2=new CacheKey("g1",ResourceType.JS,true);
  assertFalse(key1.equals(key2));
}
