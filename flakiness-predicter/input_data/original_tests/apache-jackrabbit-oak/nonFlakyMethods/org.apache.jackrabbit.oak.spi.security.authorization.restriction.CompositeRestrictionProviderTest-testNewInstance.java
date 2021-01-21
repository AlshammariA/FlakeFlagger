@Test public void testNewInstance(){
  RestrictionProvider crp=CompositeRestrictionProvider.newInstance(ImmutableSet.of(rp1,rp2));
  RestrictionProvider crp2=CompositeRestrictionProvider.newInstance(rp1,rp2);
  assertEquals(crp.getSupportedRestrictions("/testPath"),crp2.getSupportedRestrictions("/testPath"));
}
