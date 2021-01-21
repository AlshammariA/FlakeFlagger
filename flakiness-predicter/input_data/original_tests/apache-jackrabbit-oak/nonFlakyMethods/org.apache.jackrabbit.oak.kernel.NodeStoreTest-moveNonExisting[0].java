@Test public void moveNonExisting() throws CommitFailedException {
  NodeBuilder test=store.getRoot().builder().getChildNode("test");
  NodeBuilder any=test.getChildNode("any");
  NodeBuilder y=test.getChildNode("y");
  assertFalse(any.moveTo(y,"xx"));
  assertFalse(any.exists());
  assertTrue(y.exists());
  assertFalse(y.hasChildNode("xx"));
}
