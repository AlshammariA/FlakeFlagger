@Test public void testCreateRestrictionWithInvalidPath() throws Exception {
  try {
    provider.createRestriction(null,REP_GLOB,vf.createValue("*"));
    fail("rep:glob not supported at 'null' path");
  }
 catch (  AccessControlException e) {
  }
}
