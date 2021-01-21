@Test public void purgePreservesStatus() throws CommitFailedException {
  Tree x=session.getLatestRoot().getTree("/x");
  Tree added=x.addChild("added");
  for (int k=0; k < 10000; k++) {
    assertEquals("k=" + k,NEW,x.getChild("added").getStatus());
    x.addChild("k" + k);
  }
}
