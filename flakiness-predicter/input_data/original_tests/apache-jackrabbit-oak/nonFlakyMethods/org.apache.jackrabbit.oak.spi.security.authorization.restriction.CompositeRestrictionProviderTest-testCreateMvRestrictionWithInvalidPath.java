@Test public void testCreateMvRestrictionWithInvalidPath() throws Exception {
  try {
    provider.createRestriction(null,REP_NT_NAMES,new Value[]{vf.createValue("nt:base",PropertyType.NAME)});
    fail("rep:glob not supported at 'null' path");
  }
 catch (  AccessControlException e) {
  }
}
