@Test public void testCreateForUnsupportedMultiValues() throws Exception {
  try {
    restrictionProvider.createRestriction(unsupportedPath,REP_GLOB,valueFactory.createValue("*"),valueFactory.createValue("/a/*"));
    fail();
  }
 catch (  AccessControlException e) {
  }
}
