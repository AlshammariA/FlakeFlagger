@Test public void deletesMemoryNodeStore() throws CommitFailedException {
  NodeStore store=new MemoryNodeStore();
  init(store);
  run(store);
}
