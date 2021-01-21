@Test public void deletesKernelNodeStore() throws CommitFailedException {
  NodeStore store=createNodeStore();
  init(store);
  run(store);
}
