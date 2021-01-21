@Test public void testCollect() throws Exception {
  NodeBuilder b1=store.getRoot().builder();
  List<Blob> blobs=Lists.newArrayList();
  b1.child("x").child("y");
  store.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  for (int i=0; i < 2; i++) {
    b1=store.getRoot().builder();
    Blob b=store.createBlob(randomStream(i,4096));
    b1.child("x").child("y").setProperty("b" + i,b);
    blobs.add(b);
    store.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  }
  PropertyBuilder<Blob> p1=PropertyBuilder.array(Type.BINARY).setName("barr");
  for (int i=0; i < 2; i++) {
    Blob b=store.createBlob(randomStream(i,4096));
    p1.addValue(b);
    blobs.add(b);
  }
  b1=store.getRoot().builder();
  b1.child("x").child("y").setProperty(p1.getPropertyState());
  store.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  for (int i=0; i < 2; i++) {
    b1=store.getRoot().builder();
    Blob b=store.createBlob(randomStream(i + 1,4096));
    b1.child("x").child("y").setProperty("b" + i,b);
    blobs.add(b);
    store.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  }
  NodeDocument doc=store.getDocumentStore().find(Collection.NODES,Utils.getIdFromPath("/x/y"));
  List<Blob> collectedBlobs=Lists.newArrayList();
  blobCollector.collect(doc,collectedBlobs);
  assertEquals(blobs.size(),collectedBlobs.size());
  assertEquals(new HashSet<Blob>(blobs),new HashSet<Blob>(collectedBlobs));
}
