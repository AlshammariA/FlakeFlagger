@Test public void move() throws CommitFailedException {
  NodeBuilder test=store.getRoot().builder().getChildNode("test");
  NodeBuilder x=test.getChildNode("x");
  NodeBuilder y=test.getChildNode("y");
  assertTrue(x.moveTo(y,"xx"));
  assertFalse(x.exists());
  assertTrue(y.exists());
  assertFalse(test.hasChildNode("x"));
  assertTrue(y.hasChildNode("xx"));
}
