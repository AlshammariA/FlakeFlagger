/** 
 * @since OAK 1.0: support for multi-value restrictions
 */
@Test public void testGetNonExistingRestrictions() throws Exception {
  Restriction nameRestr=createRestriction(AccessControlConstants.REP_NT_NAMES,nameValues);
  ACE ace=createEntry(ImmutableSet.of(nameRestr));
  assertNull(ace.getRestrictions(AccessControlConstants.REP_GLOB));
}
