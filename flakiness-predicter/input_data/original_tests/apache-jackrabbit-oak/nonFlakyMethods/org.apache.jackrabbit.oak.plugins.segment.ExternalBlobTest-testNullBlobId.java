@Test public void testNullBlobId() throws Exception {
  FileDataStore fds=createFileDataStore();
  DataStoreBlobStore dbs=new DataStoreBlobStore(fds);
  nodeStore=getNodeStore(dbs);
  NodeBuilder nb=nodeStore.getRoot().builder();
  NodeBuilder cb=nb.child("hello");
  cb.setProperty("blob1",createBlob(Segment.MEDIUM_LIMIT - 1));
  int noOfBlobs=4000;
  for (int i=0; i < noOfBlobs; i++) {
    cb.setProperty("blob" + i,createBlob(Segment.MEDIUM_LIMIT + 1));
  }
  cb.setProperty("anotherBlob2",createBlob(Segment.MEDIUM_LIMIT + 1));
  cb.setProperty("anotherBlob3",createBlob(Segment.MEDIUM_LIMIT + 1));
  nodeStore.merge(nb,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  final List<String> refrences=Lists.newArrayList();
  store.getTracker().collectBlobReferences(new ReferenceCollector(){
    @Override public void addReference(    String reference){
      assertNotNull(reference);
      refrences.add(reference);
    }
  }
);
  assertEquals(noOfBlobs + 2,refrences.size());
}
