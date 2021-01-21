@Test public void rename() throws CommitFailedException {
  NodeBuilder test=store.getRoot().builder().getChildNode("test");
  NodeBuilder x=test.getChildNode("x");
  assertTrue(x.moveTo(test,"xx"));
  assertFalse(x.exists());
  assertFalse(test.hasChildNode("x"));
  assertTrue(test.hasChildNode("xx"));
}
