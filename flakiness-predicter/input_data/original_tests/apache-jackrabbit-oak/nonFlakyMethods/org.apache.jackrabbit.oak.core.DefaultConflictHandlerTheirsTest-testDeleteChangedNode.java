@Test public void testDeleteChangedNode() throws CommitFailedException {
  theirRoot.getTree("/x").setProperty("p",THEIR_VALUE);
  ourRoot.getTree("/x").remove();
  theirRoot.commit();
  ourRoot.commit();
  Tree n=ourRoot.getTree("/x");
  assertTrue(n.exists());
  assertEquals(THEIR_VALUE,n.getProperty("p").getValue(STRING));
}
