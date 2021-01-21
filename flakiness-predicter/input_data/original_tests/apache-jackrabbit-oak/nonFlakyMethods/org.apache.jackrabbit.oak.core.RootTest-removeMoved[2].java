/** 
 * Regression test for OAK-208
 */
@Test public void removeMoved() throws CommitFailedException {
  Root root=session.getLatestRoot();
  Tree r=root.getTree("/");
  r.addChild("a");
  r.addChild("b");
  root.move("/a","/b/c");
  assertFalse(r.hasChild("a"));
  assertTrue(r.hasChild("b"));
  r.getChild("b").remove();
  assertFalse(r.hasChild("a"));
  assertFalse(r.hasChild("b"));
  root.commit();
  assertFalse(r.hasChild("a"));
  assertFalse(r.hasChild("b"));
}
