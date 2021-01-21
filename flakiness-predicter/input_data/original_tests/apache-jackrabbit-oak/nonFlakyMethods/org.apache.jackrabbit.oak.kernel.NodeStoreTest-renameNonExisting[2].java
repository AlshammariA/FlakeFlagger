@Test public void renameNonExisting() throws CommitFailedException {
  NodeBuilder test=store.getRoot().builder().getChildNode("test");
  NodeBuilder any=test.getChildNode("any");
  assertFalse(any.moveTo(test,"xx"));
  assertFalse(any.exists());
  assertFalse(test.hasChildNode("xx"));
}
