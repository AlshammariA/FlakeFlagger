@Test public void testGetSupportedDefinitions(){
  assertTrue(provider.getSupportedRestrictions(null).isEmpty());
  Set<RestrictionDefinition> defs=provider.getSupportedRestrictions("/testPath");
  assertNotNull(defs);
  assertEquals(3,defs.size());
  for (  RestrictionDefinition def : defs) {
    if (REP_GLOB.equals(def.getName())) {
      assertEquals(Type.STRING,def.getRequiredType());
      assertFalse(def.isMandatory());
    }
 else     if (REP_NT_NAMES.equals(def.getName())) {
      assertEquals(Type.NAMES,def.getRequiredType());
      assertFalse(def.isMandatory());
    }
 else     if (REP_PREFIXES.equals(def.getName())) {
      assertEquals(Type.STRINGS,def.getRequiredType());
      assertFalse(def.isMandatory());
    }
 else {
      fail("unexpected restriction " + def.getName());
    }
  }
}
