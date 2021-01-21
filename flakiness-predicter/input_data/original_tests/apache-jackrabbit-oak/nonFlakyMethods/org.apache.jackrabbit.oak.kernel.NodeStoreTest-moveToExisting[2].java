@Test public void moveToExisting() throws CommitFailedException {
  NodeBuilder test=store.getRoot().builder().getChildNode("test");
  NodeBuilder x=test.getChildNode("x");
  assertFalse(x.moveTo(test,"y"));
  assertTrue(x.exists());
  assertTrue(test.hasChildNode("x"));
  assertTrue(test.hasChildNode("y"));
}
