/** 
 * @since OAK 1.0: support for multi-value restrictions
 */
@Test public void testGetRestrictionForMultiValued2() throws Exception {
  Restriction singleNameRestr=createRestriction(AccessControlConstants.REP_NT_NAMES,new Value[]{nameValue});
  ACE ace=createEntry(ImmutableSet.of(singleNameRestr));
  Value val=ace.getRestriction(AccessControlConstants.REP_NT_NAMES);
  assertEquals(nameValue,val);
}
