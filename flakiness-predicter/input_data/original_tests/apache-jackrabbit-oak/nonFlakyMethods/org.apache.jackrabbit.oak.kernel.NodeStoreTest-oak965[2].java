@Test public void oak965() throws CommitFailedException {
  NodeStore store1=init(fixture.createNodeStore());
  NodeStore store2=init(fixture.createNodeStore());
  try {
    NodeState tree1=store1.getRoot();
    NodeState tree2=store2.getRoot();
    tree1.equals(tree2);
  }
  finally {
    fixture.dispose(store1);
    fixture.dispose(store2);
  }
}
