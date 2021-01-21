@Test public void shouldCreateValidCacheKeyWhenRequestContainsAllRequiredInfo(){
  when(mockGroupExtractor.isMinimized(mockRequest)).thenReturn(true);
  when(mockGroupExtractor.getGroupName(mockRequest)).thenReturn("g1");
  when(mockGroupExtractor.getResourceType(mockRequest)).thenReturn(ResourceType.CSS);
  assertEquals(new CacheKey("g1",ResourceType.CSS,true),victim.create(mockRequest));
}
