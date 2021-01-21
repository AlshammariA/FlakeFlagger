@Test public void testValidateRestrictionsUnsupportedPath() throws Exception {
  restrictionProvider.validateRestrictions(null,getAceTree());
  try {
    Restriction restr=restrictionProvider.createRestriction(testPath,REP_GLOB,globValue);
    restrictionProvider.validateRestrictions(null,getAceTree(restr));
    fail();
  }
 catch (  AccessControlException e) {
  }
}
