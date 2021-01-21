/** 
 * @since OAK 1.0: support for multi-value restrictions
 */
@Test public void testGetEmptyRestrictions() throws Exception {
  Value[] vs=createEntry(Collections.<Restriction>emptySet()).getRestrictions(AccessControlConstants.REP_GLOB);
  assertNull(vs);
}
