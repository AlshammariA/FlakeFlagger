@Test public void testGetNonExistingRestriction() throws Exception {
  Restriction globRestr=createRestriction(AccessControlConstants.REP_GLOB,globValue);
  ACE ace=createEntry(ImmutableSet.of(globRestr));
  assertNull(ace.getRestriction(AccessControlConstants.REP_NT_NAMES));
}
