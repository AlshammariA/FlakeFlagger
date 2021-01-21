@Test public void testBlobIterator() throws Exception {
  List<Blob> blobs=Lists.newArrayList();
  for (int i=0; i < 10; i++) {
    NodeBuilder b1=store.getRoot().builder();
    Blob b=store.createBlob(randomStream(i,4096));
    b1.child("x").child("y" + 1).setProperty("b" + i,b);
    blobs.add(b);
    store.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  }
  List<Blob> collectedBlobs=ImmutableList.copyOf(store.getReferencedBlobsIterator());
  assertEquals(blobs.size(),collectedBlobs.size());
  assertEquals(new HashSet<Blob>(blobs),new HashSet<Blob>(collectedBlobs));
}
