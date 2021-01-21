/** 
 * @since OAK 1.0: support for multi-value restrictions
 */
@Test public void testGetRestrictionsForMultiValued2() throws Exception {
  Restriction singleNameRestr=createRestriction(AccessControlConstants.REP_NT_NAMES,new Value[]{nameValue});
  ACE ace=createEntry(ImmutableSet.of(singleNameRestr));
  Value[] vs=ace.getRestrictions(AccessControlConstants.REP_NT_NAMES);
  assertEquals(1,vs.length);
  assertEquals(nameValue,vs[0]);
}
