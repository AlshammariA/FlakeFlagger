@Test public void addingNullAttributeValueShouldHaveNoEffect(){
  final CacheKey key=createValidCacheKey().addAttribute("key1",null);
  assertEquals(key,createValidCacheKey());
}
