@Test public void shouldCreateNullCacheKeyWhenRequestDoesNotGroupName(){
  when(mockGroupExtractor.getGroupName(mockRequest)).thenReturn(null);
  when(mockGroupExtractor.getResourceType(mockRequest)).thenReturn(ResourceType.CSS);
  assertNull(victim.create(mockRequest));
}
