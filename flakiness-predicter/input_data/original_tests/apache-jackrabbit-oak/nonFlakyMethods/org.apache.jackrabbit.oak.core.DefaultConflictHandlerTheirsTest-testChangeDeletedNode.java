@Test public void testChangeDeletedNode() throws CommitFailedException {
  theirRoot.getTree("/x").remove();
  ourRoot.getTree("/x").setProperty("p",OUR_VALUE);
  theirRoot.commit();
  ourRoot.commit();
  Tree n=ourRoot.getTree("/x");
  assertFalse(n.exists());
}
