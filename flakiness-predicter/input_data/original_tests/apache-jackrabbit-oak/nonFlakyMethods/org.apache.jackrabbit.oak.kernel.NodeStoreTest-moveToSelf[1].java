@Test public void moveToSelf() throws CommitFailedException {
  NodeBuilder test=store.getRoot().builder().getChildNode("test");
  NodeBuilder x=test.getChildNode("x");
  assertFalse(x.moveTo(test,"x"));
  assertTrue(x.exists());
  assertTrue(test.hasChildNode("x"));
}
