@Test public void testGetSupportedRestrictions(){
  String[] paths=new String[]{null,"/testPath"};
  for (  String path : paths) {
    Set<RestrictionDefinition> defs=provider.getSupportedRestrictions(path);
    int expectedSize=rp1.getSupportedRestrictions(path).size() + rp2.getSupportedRestrictions(path).size();
    assertEquals(expectedSize,defs.size());
    assertTrue(defs.containsAll(rp1.getSupportedRestrictions(path)));
    assertTrue(defs.containsAll(rp2.getSupportedRestrictions(path)));
  }
}
