@Test public void testSingle(){
  RestrictionProvider rp=new RestrictionProviderImpl();
  assertSame(rp,CompositeRestrictionProvider.newInstance(Collections.singleton(rp)));
}
