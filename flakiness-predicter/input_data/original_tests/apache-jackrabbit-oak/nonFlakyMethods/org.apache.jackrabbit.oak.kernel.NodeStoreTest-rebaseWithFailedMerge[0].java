@Test public void rebaseWithFailedMerge() throws CommitFailedException {
  NodeBuilder rootBuilder=store.getRoot().builder();
  rootBuilder.child("foo");
  NodeBuilder b=store.getRoot().builder();
  b.child("bar");
  store.merge(b,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  try {
    store.merge(rootBuilder,new CommitHook(){
      @Nonnull @Override public NodeState processCommit(      NodeState before,      NodeState after,      CommitInfo info) throws CommitFailedException {
        throw new CommitFailedException("",0,"commit rejected");
      }
    }
,CommitInfo.EMPTY);
    fail("must throw CommitFailedException");
  }
 catch (  CommitFailedException e) {
  }
  NodeState root=store.merge(rootBuilder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue(root.hasChildNode("bar"));
}
