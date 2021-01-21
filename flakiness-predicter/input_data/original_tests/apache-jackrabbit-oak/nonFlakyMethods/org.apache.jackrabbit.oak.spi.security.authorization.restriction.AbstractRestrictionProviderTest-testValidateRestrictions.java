@Test public void testValidateRestrictions() throws Exception {
  Restriction glob=restrictionProvider.createRestriction(testPath,REP_GLOB,globValue);
  Restriction ntNames=restrictionProvider.createRestriction(testPath,REP_NT_NAMES,nameValues);
  Restriction mand=restrictionProvider.createRestriction(testPath,"mandatory",valueFactory.createValue(true));
  restrictionProvider.validateRestrictions(testPath,getAceTree(mand));
  restrictionProvider.validateRestrictions(testPath,getAceTree(mand,glob));
  restrictionProvider.validateRestrictions(testPath,getAceTree(mand,ntNames));
  restrictionProvider.validateRestrictions(testPath,getAceTree(mand,glob,ntNames));
}
