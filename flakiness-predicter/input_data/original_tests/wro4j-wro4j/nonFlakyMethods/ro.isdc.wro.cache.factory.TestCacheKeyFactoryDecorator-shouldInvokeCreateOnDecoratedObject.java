@Test public void shouldInvokeCreateOnDecoratedObject(){
  victim.create(mockRequest);
  verify(mockCacheKeyFactory).create(mockRequest);
}
