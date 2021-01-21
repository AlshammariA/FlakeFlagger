@Test public void testCreateEmptyMvRestriction2() throws Exception {
  Restriction r=restrictionProvider.createRestriction(testPath,REP_NT_NAMES,new Value[0]);
  assertNotNull(r);
  assertEquals(REP_NT_NAMES,r.getDefinition().getName());
  assertEquals(Type.NAMES,r.getDefinition().getRequiredType());
  assertTrue(r.getProperty().isArray());
  assertEquals(Type.NAMES,r.getProperty().getType());
  List<Value> vs=ValueFactoryImpl.createValues(r.getProperty(),namePathMapper);
  assertNotNull(vs);
  assertEquals(0,vs.size());
}
