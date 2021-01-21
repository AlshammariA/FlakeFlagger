@Test public void testGetRestrictionForSingleValued() throws Exception {
  Restriction globRestr=createRestriction(AccessControlConstants.REP_GLOB,globValue);
  ACE ace=createEntry(ImmutableSet.of(globRestr));
  Value val=ace.getRestriction(AccessControlConstants.REP_GLOB);
  assertNotNull(val);
  assertEquals(globValue,val);
}
