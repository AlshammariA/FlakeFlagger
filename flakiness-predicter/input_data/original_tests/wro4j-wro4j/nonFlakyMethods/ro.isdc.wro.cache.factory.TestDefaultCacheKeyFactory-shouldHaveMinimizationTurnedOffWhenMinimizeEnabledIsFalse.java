@Test public void shouldHaveMinimizationTurnedOffWhenMinimizeEnabledIsFalse() throws IOException {
  when(mockGroupExtractor.isMinimized(mockRequest)).thenReturn(true);
  when(mockGroupExtractor.getGroupName(mockRequest)).thenReturn("g1");
  when(mockGroupExtractor.getResourceType(mockRequest)).thenReturn(ResourceType.CSS);
  Context.get().getConfig().setMinimizeEnabled(false);
  assertEquals(new CacheKey("g1",ResourceType.CSS,false),victim.create(mockRequest));
}
