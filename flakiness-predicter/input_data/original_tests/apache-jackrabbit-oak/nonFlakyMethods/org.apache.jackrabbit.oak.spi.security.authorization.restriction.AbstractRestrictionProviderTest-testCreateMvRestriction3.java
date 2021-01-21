@Test public void testCreateMvRestriction3() throws Exception {
  Restriction r=restrictionProvider.createRestriction(testPath,REP_NT_NAMES,nameValue);
  assertNotNull(r);
  assertEquals(REP_NT_NAMES,r.getDefinition().getName());
  assertEquals(Type.NAMES,r.getDefinition().getRequiredType());
  assertTrue(r.getProperty().isArray());
  assertEquals(Type.NAMES,r.getProperty().getType());
  List<Value> vs=ValueFactoryImpl.createValues(r.getProperty(),namePathMapper);
  assertArrayEquals(new Value[]{nameValue},vs.toArray(new Value[vs.size()]));
}
