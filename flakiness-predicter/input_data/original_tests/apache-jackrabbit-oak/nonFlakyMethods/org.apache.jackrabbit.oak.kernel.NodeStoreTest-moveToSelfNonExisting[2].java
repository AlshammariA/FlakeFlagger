@Test public void moveToSelfNonExisting() throws CommitFailedException {
  NodeBuilder test=store.getRoot().builder().getChildNode("test");
  NodeBuilder any=test.getChildNode("any");
  assertFalse(any.moveTo(test,"any"));
  assertFalse(any.exists());
  assertFalse(test.hasChildNode("any"));
}
