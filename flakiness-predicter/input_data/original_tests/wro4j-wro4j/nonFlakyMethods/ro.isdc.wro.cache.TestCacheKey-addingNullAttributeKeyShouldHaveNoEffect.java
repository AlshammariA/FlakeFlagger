@Test public void addingNullAttributeKeyShouldHaveNoEffect(){
  final CacheKey key=createValidCacheKey().addAttribute(null,"");
  assertEquals(key,createValidCacheKey());
}
