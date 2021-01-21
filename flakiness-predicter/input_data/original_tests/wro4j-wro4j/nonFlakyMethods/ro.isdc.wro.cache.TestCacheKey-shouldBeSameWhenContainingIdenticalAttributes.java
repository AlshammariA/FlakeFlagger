@Test public void shouldBeSameWhenContainingIdenticalAttributes(){
  final CacheKey key1=createValidCacheKey().addAttribute("k1","v1");
  final CacheKey key2=createValidCacheKey().addAttribute("k1","v1");
  assertEquals(key1,key2);
  assertEquals(key1.hashCode(),key2.hashCode());
}
