@Test public void testCreateForUnsupportedPath() throws Exception {
  try {
    restrictionProvider.createRestriction(unsupportedPath,REP_GLOB,globValue);
    fail();
  }
 catch (  AccessControlException e) {
  }
  try {
    restrictionProvider.createRestriction(unsupportedPath,REP_NT_NAMES,nameValues);
    fail();
  }
 catch (  AccessControlException e) {
  }
}
