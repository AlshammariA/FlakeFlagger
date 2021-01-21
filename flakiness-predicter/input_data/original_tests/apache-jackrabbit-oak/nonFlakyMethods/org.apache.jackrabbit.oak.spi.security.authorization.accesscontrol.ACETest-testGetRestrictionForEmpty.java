@Test public void testGetRestrictionForEmpty() throws Exception {
  Value val=createEntry(Collections.<Restriction>emptySet()).getRestriction(AccessControlConstants.REP_GLOB);
  assertNull(val);
}
