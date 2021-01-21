/** 
 * @since OAK 1.0: support for multi-value restrictions
 */
@Test public void testGetRestrictionForMultiValued() throws Exception {
  Restriction nameRestr=createRestriction(AccessControlConstants.REP_NT_NAMES,nameValues);
  ACE ace=createEntry(ImmutableSet.of(nameRestr));
  try {
    ace.getRestriction(AccessControlConstants.REP_NT_NAMES);
    fail("Multiple restriction values");
  }
 catch (  ValueFormatException e) {
  }
}
