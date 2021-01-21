@Test public void concurrentUpdates() throws Exception {
  final DocumentNodeStore store=mk.getNodeStore();
  NodeBuilder builder=store.getRoot().builder();
  builder.child("test").setProperty("prop",System.currentTimeMillis());
  store.merge(builder,HOOK,CommitInfo.EMPTY);
  List<Callable<Object>> tasks=Lists.newArrayList();
  for (int i=0; i < NUM_THREADS; i++) {
    tasks.add(new Callable<Object>(){
      @Override public Object call() throws Exception {
        for (int i=0; i < 100; i++) {
          try {
            NodeBuilder builder=store.getRoot().builder();
            builder.getChildNode("test").setProperty("prop",Math.random());
            store.merge(builder,HOOK,CommitInfo.EMPTY);
          }
 catch (          CommitFailedException e) {
            RepositoryException ex=e.asRepositoryException();
            if (!(ex instanceof InvalidItemStateException)) {
              throw e;
            }
          }
        }
        return null;
      }
    }
);
  }
  List<Future<Object>> results=service.invokeAll(tasks);
  for (  Future<Object> r : results) {
    r.get();
  }
}
