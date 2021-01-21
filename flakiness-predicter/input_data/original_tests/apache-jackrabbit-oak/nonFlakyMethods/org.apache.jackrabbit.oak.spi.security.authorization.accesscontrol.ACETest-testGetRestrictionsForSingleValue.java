/** 
 * @since OAK 1.0: support for multi-value restrictions
 */
@Test public void testGetRestrictionsForSingleValue() throws Exception {
  Restriction globRestr=createRestriction(AccessControlConstants.REP_GLOB,globValue);
  ACE ace=createEntry(ImmutableSet.of(globRestr));
  Value[] vs=ace.getRestrictions(AccessControlConstants.REP_GLOB);
  assertNotNull(vs);
  assertArrayEquals(new Value[]{globValue},vs);
}
