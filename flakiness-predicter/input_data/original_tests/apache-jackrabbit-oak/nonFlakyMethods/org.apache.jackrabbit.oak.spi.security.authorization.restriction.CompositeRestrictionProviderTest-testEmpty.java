@Test public void testEmpty(){
  assertSame(RestrictionProvider.EMPTY,CompositeRestrictionProvider.newInstance(Collections.<RestrictionProvider>emptySet()));
}
