@Test public void shouldCreateNullCacheKeyWhenRequestDoesNotContainEnoughInfo(){
  assertNull(victim.create(mockRequest));
}
