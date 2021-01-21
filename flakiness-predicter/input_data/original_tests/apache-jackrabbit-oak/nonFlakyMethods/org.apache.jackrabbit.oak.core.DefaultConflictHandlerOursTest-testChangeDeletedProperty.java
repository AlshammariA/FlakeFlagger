@Test public void testChangeDeletedProperty() throws CommitFailedException {
  theirRoot.getTree("/").removeProperty("a");
  ourRoot.getTree("/").setProperty("a",OUR_VALUE);
  theirRoot.commit();
  ourRoot.commit();
  PropertyState p=ourRoot.getTree("/").getProperty("a");
  assertNotNull(p);
  assertEquals(OUR_VALUE,p.getValue(STRING));
}
