@Test public void test() throws Exception {
  DocumentNodeStore s=new DocumentMK.Builder().getNodeStore();
  NodeBuilder a=s.getRoot().builder();
  HashSet<String> set=new HashSet<String>();
  for (int i=0; i < 100; i++) {
    Blob b=a.createBlob(randomStream(i,10));
    set.add(b.toString());
    a.child("c" + i).setProperty("x",b);
  }
  s.merge(a,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  Iterator<Blob> it=s.getReferencedBlobsIterator();
  while (it.hasNext()) {
    Blob b=it.next();
    set.remove(b.toString());
  }
  assertTrue(set.isEmpty());
  s.dispose();
}
