/** 
 * @since OAK 1.0: support for multi-value restrictions
 */
@Test public void testGetRestrictionsForMultiValued() throws Exception {
  Restriction nameRestr=createRestriction(AccessControlConstants.REP_NT_NAMES,nameValues);
  ACE ace=createEntry(ImmutableSet.of(nameRestr));
  Value[] vs=ace.getRestrictions(AccessControlConstants.REP_NT_NAMES);
  assertEquals(2,vs.length);
  assertArrayEquals(nameValues,vs);
}
