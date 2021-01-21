@Test public void testValidateRestrictionsMissingMandatory() throws Exception {
  Restriction glob=restrictionProvider.createRestriction(testPath,REP_GLOB,globValue);
  try {
    restrictionProvider.validateRestrictions(testPath,getAceTree(glob));
    fail("missing mandatory restriction");
  }
 catch (  AccessControlException e) {
  }
}
