@Test public void shouldReturnCorrectDecorateObject(){
  assertSame(mockCacheKeyFactory,victim.getDecoratedObject());
}
