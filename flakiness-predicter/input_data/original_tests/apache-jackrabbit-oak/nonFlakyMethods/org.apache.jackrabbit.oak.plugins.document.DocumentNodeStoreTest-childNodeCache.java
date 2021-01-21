@Test public void childNodeCache() throws Exception {
  DocumentNodeStore store=new DocumentMK.Builder().getNodeStore();
  NodeBuilder builder=store.getRoot().builder();
  int max=(int)(KernelNodeState.MAX_CHILD_NAMES * 1.5);
  SortedSet<String> children=new TreeSet<String>();
  for (int i=0; i < max; i++) {
    String name="c" + i;
    children.add(name);
    builder.child(name);
  }
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  builder=store.getRoot().builder();
  String name=new ArrayList<String>(children).get(KernelNodeState.MAX_CHILD_NAMES / 2);
  builder.child(name).remove();
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  int numEntries=Iterables.size(store.getRoot().getChildNodeEntries());
  assertEquals(max - 1,numEntries);
  store.dispose();
}
