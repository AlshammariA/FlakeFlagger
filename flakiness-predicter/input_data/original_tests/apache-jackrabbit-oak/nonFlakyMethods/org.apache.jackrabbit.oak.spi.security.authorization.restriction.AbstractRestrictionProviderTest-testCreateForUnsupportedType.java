@Test public void testCreateForUnsupportedType() throws Exception {
  try {
    restrictionProvider.createRestriction(unsupportedPath,REP_GLOB,valueFactory.createValue(true));
    fail();
  }
 catch (  AccessControlException e) {
  }
  try {
    restrictionProvider.createRestriction(unsupportedPath,REP_NT_NAMES,valueFactory.createValue("nt:file",PropertyType.NAME),valueFactory.createValue(true));
    fail();
  }
 catch (  AccessControlException e) {
  }
}
