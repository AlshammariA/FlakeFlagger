@Test public void testReadRestrictions() throws Exception {
  Restriction r=restrictionProvider.createRestriction(testPath,REP_GLOB,globValue);
  Tree aceTree=getAceTree(r);
  Set<Restriction> restrictions=restrictionProvider.readRestrictions(testPath,aceTree);
  assertEquals(1,restrictions.size());
  assertTrue(restrictions.contains(r));
}
