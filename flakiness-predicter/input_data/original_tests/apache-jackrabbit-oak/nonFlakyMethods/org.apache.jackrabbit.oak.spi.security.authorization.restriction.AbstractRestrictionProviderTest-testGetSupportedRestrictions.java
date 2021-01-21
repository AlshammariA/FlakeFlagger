@Test public void testGetSupportedRestrictions() throws Exception {
  Set<RestrictionDefinition> defs=restrictionProvider.getSupportedRestrictions(testPath);
  assertNotNull(defs);
  assertEquals(supported.size(),defs.size());
  for (  RestrictionDefinition def : supported.values()) {
    assertTrue(defs.contains(def));
  }
}
