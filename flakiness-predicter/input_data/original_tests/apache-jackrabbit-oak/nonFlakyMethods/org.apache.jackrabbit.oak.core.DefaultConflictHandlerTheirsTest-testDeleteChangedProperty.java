@Test public void testDeleteChangedProperty() throws CommitFailedException {
  theirRoot.getTree("/").setProperty("a",THEIR_VALUE);
  ourRoot.getTree("/").removeProperty("a");
  theirRoot.commit();
  ourRoot.commit();
  PropertyState p=ourRoot.getTree("/").getProperty("a");
  assertNotNull(p);
  assertEquals(THEIR_VALUE,p.getValue(STRING));
}
