@Test public void testGetRestrictionNames() throws Exception {
  String[] restrictionNames=createEntry(Collections.<Restriction>emptySet()).getRestrictionNames();
  assertNotNull(restrictionNames);
  assertEquals(0,restrictionNames.length);
  Restriction globRestr=createRestriction(AccessControlConstants.REP_GLOB,globValue);
  Restriction nameRestr=createRestriction(AccessControlConstants.REP_NT_NAMES,nameValues);
  restrictionNames=createEntry(ImmutableSet.of(globRestr)).getRestrictionNames();
  assertEquals(1,restrictionNames.length);
  restrictionNames=createEntry(ImmutableSet.of(globRestr,nameRestr)).getRestrictionNames();
  assertEquals(2,restrictionNames.length);
}
