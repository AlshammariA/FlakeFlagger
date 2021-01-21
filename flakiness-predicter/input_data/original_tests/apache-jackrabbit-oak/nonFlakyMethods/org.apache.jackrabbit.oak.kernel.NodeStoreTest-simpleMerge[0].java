@Test public void simpleMerge() throws CommitFailedException {
  NodeBuilder rootBuilder=store.getRoot().builder();
  NodeBuilder testBuilder=rootBuilder.child("test");
  NodeBuilder newNodeBuilder=testBuilder.child("newNode");
  testBuilder.getChildNode("x").remove();
  newNodeBuilder.setProperty("n",42);
  NodeState testState=rootBuilder.getNodeState().getChildNode("test");
  assertTrue(testState.getChildNode("newNode").exists());
  assertFalse(testState.getChildNode("x").exists());
  assertEquals(42,(long)testState.getChildNode("newNode").getProperty("n").getValue(LONG));
  testState=store.getRoot().getChildNode("test");
  assertFalse(testState.getChildNode("newNode").exists());
  assertTrue(testState.getChildNode("x").exists());
  store.merge(rootBuilder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  testState=store.getRoot().getChildNode("test");
  assertTrue(testState.getChildNode("newNode").exists());
  assertFalse(testState.getChildNode("x").exists());
  assertEquals(42,(long)testState.getChildNode("newNode").getProperty("n").getValue(LONG));
}
