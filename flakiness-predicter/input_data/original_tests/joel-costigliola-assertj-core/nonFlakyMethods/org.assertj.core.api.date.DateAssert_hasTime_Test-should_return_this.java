@Test public void should_return_this(){
  DateAssert returned=assertions.hasTime(42L);
  assertSame(assertions,returned);
}
