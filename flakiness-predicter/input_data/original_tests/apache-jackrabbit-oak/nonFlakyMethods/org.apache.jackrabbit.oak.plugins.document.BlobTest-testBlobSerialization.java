@Test public void testBlobSerialization() throws Exception {
  TestBlobStore blobStore=new TestBlobStore();
  DocumentMK mk=new DocumentMK.Builder().setBlobStore(blobStore).open();
  BlobSerializer blobSerializer=mk.getNodeStore().getBlobSerializer();
  Blob blob=new BlobStoreBlob(blobStore,"foo");
  assertEquals("foo",blobSerializer.serialize(blob));
  assertEquals(0,blobStore.writeCount);
  blob=new ArrayBasedBlob("foo".getBytes());
  blobSerializer.serialize(blob);
  assertEquals(1,blobStore.writeCount);
  byte[] bytes="foo".getBytes();
  String blobId=blobStore.writeBlob(new ByteArrayInputStream(bytes));
  String reference=blobStore.getReference(blobId);
  blob=new ReferencedBlob("foo".getBytes(),reference);
  blobStore.writeCount=0;
  blobSerializer.serialize(blob);
  assertEquals(0,blobStore.writeCount);
}
