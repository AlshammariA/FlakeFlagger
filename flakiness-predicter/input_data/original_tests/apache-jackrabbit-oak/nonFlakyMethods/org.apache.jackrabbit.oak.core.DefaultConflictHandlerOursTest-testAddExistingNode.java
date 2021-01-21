@Test public void testAddExistingNode() throws CommitFailedException {
  theirRoot.getTree("/").addChild("n").setProperty("p",THEIR_VALUE);
  ourRoot.getTree("/").addChild("n").setProperty("p",OUR_VALUE);
  theirRoot.commit();
  ourRoot.commit();
  Tree n=ourRoot.getTree("/n");
  assertTrue(n.exists());
  assertEquals(OUR_VALUE,n.getProperty("p").getValue(STRING));
}
