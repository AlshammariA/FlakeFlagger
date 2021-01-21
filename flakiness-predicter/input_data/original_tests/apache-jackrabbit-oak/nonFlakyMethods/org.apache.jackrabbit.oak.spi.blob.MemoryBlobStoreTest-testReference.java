@Test public void testReference() throws Exception {
  assumeThat(store,instanceOf(AbstractBlobStore.class));
  AbstractBlobStore abs=(AbstractBlobStore)store;
  Random r=new Random();
  byte[] key=new byte[256];
  r.nextBytes(key);
  abs.setReferenceKey(key);
  byte[] data=new byte[1000];
  r.nextBytes(data);
  String blobId=store.writeBlob(new ByteArrayInputStream(data));
  String reference=store.getReference(blobId);
  String blobId2=store.getBlobId(reference);
  assertEquals(blobId,blobId2);
}
