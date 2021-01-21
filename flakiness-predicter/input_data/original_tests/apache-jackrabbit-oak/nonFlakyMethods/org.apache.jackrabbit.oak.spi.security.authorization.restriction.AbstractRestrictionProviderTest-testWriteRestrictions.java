@Test public void testWriteRestrictions() throws Exception {
  Restriction r=restrictionProvider.createRestriction(testPath,REP_GLOB,globValue);
  Tree aceTree=getAceTree();
  restrictionProvider.writeRestrictions(testPath,aceTree,ImmutableSet.<Restriction>of(r));
  assertTrue(aceTree.hasChild(REP_RESTRICTIONS));
  Tree restr=aceTree.getChild(REP_RESTRICTIONS);
  assertEquals(r.getProperty(),restr.getProperty(REP_GLOB));
}
