@Test public void testAddExistingProperties() throws CommitFailedException {
  theirRoot.getTree("/").setProperty("p",THEIR_VALUE);
  theirRoot.getTree("/").setProperty("q",THEIR_VALUE);
  ourRoot.getTree("/").setProperty("p",OUR_VALUE);
  ourRoot.getTree("/").setProperty("q",OUR_VALUE);
  theirRoot.commit();
  ourRoot.commit();
  PropertyState p=ourRoot.getTree("/").getProperty("p");
  assertNotNull(p);
  assertEquals(OUR_VALUE,p.getValue(STRING));
  PropertyState q=ourRoot.getTree("/").getProperty("q");
  assertNotNull(q);
  assertEquals(OUR_VALUE,p.getValue(STRING));
}
