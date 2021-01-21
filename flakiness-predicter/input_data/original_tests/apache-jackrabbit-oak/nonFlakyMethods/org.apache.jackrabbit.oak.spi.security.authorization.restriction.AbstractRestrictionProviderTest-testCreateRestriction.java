@Test public void testCreateRestriction() throws Exception {
  Restriction r=restrictionProvider.createRestriction(testPath,REP_GLOB,globValue);
  assertNotNull(r);
  assertEquals(REP_GLOB,r.getDefinition().getName());
  assertEquals(globValue.getString(),r.getProperty().getValue(Type.STRING));
}
