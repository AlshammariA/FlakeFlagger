@Test public void shouldCreateNullCacheKeyWhenRequestDoesNotContainResourceType(){
  when(mockGroupExtractor.getGroupName(mockRequest)).thenReturn("g1");
  when(mockGroupExtractor.getResourceType(mockRequest)).thenReturn(null);
  assertNull(victim.create(mockRequest));
}
