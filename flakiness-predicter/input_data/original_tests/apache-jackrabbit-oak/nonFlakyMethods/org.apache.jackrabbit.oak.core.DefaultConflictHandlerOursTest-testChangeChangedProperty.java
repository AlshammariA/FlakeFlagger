@Test public void testChangeChangedProperty() throws CommitFailedException {
  theirRoot.getTree("/").setProperty("a",THEIR_VALUE);
  ourRoot.getTree("/").setProperty("a",OUR_VALUE);
  theirRoot.commit();
  ourRoot.commit();
  PropertyState p=ourRoot.getTree("/").getProperty("a");
  assertNotNull(p);
  assertEquals(OUR_VALUE,p.getValue(STRING));
}
