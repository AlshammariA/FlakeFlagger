@Test public void testReadRestrictionsForUnsupportedPath() throws Exception {
  Set<Restriction> restrictions=restrictionProvider.readRestrictions(unsupportedPath,getAceTree());
  assertTrue(restrictions.isEmpty());
}
