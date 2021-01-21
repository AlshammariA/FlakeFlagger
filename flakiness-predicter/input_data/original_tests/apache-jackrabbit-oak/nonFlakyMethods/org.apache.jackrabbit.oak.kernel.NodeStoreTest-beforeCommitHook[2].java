@Test public void beforeCommitHook() throws CommitFailedException {
  NodeState root=store.getRoot();
  NodeBuilder rootBuilder=root.builder();
  NodeBuilder testBuilder=rootBuilder.child("test");
  NodeBuilder newNodeBuilder=testBuilder.child("newNode");
  newNodeBuilder.setProperty("n",42);
  testBuilder.getChildNode("a").remove();
  store.merge(rootBuilder,new CommitHook(){
    @Override public NodeState processCommit(    NodeState before,    NodeState after,    CommitInfo info){
      NodeBuilder rootBuilder=after.builder();
      NodeBuilder testBuilder=rootBuilder.child("test");
      testBuilder.child("fromHook");
      return rootBuilder.getNodeState();
    }
  }
,CommitInfo.EMPTY);
  NodeState test=store.getRoot().getChildNode("test");
  assertTrue(test.getChildNode("newNode").exists());
  assertTrue(test.getChildNode("fromHook").exists());
  assertFalse(test.getChildNode("a").exists());
  assertEquals(42,(long)test.getChildNode("newNode").getProperty("n").getValue(LONG));
  assertEquals(test,store.getRoot().getChildNode("test"));
}
