@Test public void testCreateMvRestriction2() throws Exception {
  Restriction r=restrictionProvider.createRestriction(testPath,REP_NT_NAMES,nameValues);
  assertNotNull(r);
  assertEquals(REP_NT_NAMES,r.getDefinition().getName());
  assertEquals(Type.NAMES,r.getDefinition().getRequiredType());
  PropertyState ps=r.getProperty();
  assertTrue(ps.isArray());
  assertEquals(Type.NAMES,ps.getType());
  List<Value> vs=ValueFactoryImpl.createValues(ps,namePathMapper);
  assertArrayEquals(nameValues,vs.toArray(new Value[vs.size()]));
}
