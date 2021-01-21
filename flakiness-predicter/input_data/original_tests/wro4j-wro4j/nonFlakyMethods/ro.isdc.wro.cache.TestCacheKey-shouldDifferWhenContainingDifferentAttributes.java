@Test public void shouldDifferWhenContainingDifferentAttributes(){
  final CacheKey key1=createValidCacheKey().addAttribute("k1","v1").addAttribute("k2","v2");
  final CacheKey key2=createValidCacheKey().addAttribute("k1","v1");
  assertFalse(key1.equals(key2));
  assertFalse(key1.hashCode() == key2.hashCode());
}
