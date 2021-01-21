@Test public void testWriteInvalidRestrictions() throws Exception {
  PropertyState ps=PropertyStates.createProperty(REP_GLOB,valueFactory.createValue(false));
  Tree aceTree=getAceTree();
  restrictionProvider.writeRestrictions(testPath,aceTree,ImmutableSet.<Restriction>of(new RestrictionImpl(ps,false)));
  assertTrue(aceTree.hasChild(REP_RESTRICTIONS));
  Tree restr=aceTree.getChild(REP_RESTRICTIONS);
  assertEquals(ps,restr.getProperty(REP_GLOB));
}
