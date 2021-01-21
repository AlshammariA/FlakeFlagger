@Test public void testValidateRestrictionsWrongType() throws Exception {
  Restriction mand=restrictionProvider.createRestriction(testPath,"mandatory",valueFactory.createValue(true));
  try {
    Tree ace=getAceTree(mand);
    new NodeUtil(ace).getChild(REP_RESTRICTIONS).setBoolean(REP_GLOB,true);
    restrictionProvider.validateRestrictions(testPath,ace);
    fail("wrong type with restriction 'rep:glob");
  }
 catch (  AccessControlException e) {
  }
}
