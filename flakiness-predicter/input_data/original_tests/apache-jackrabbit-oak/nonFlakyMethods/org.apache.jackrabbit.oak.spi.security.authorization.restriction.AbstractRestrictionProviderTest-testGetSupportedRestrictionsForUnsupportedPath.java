@Test public void testGetSupportedRestrictionsForUnsupportedPath() throws Exception {
  Set<RestrictionDefinition> defs=restrictionProvider.getSupportedRestrictions(unsupportedPath);
  assertNotNull(defs);
  assertTrue(defs.isEmpty());
}
