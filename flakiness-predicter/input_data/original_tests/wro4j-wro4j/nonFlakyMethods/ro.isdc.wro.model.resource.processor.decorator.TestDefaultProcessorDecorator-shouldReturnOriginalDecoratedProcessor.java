@Test public void shouldReturnOriginalDecoratedProcessor(){
  Assert.assertSame(mockProcessor,victim.getOriginalDecoratedObject());
}
