@Test public void testDeleteChangedNode() throws CommitFailedException {
  theirRoot.getTree("/x").setProperty("p",THEIR_VALUE);
  ourRoot.getTree("/x").remove();
  theirRoot.commit();
  ourRoot.commit();
  Tree n=ourRoot.getTree("/x");
  assertFalse(n.exists());
}
