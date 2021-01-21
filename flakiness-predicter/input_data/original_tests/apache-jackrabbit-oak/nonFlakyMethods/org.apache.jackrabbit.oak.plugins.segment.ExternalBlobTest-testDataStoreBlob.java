@Test public void testDataStoreBlob() throws Exception {
  FileDataStore fds=createFileDataStore();
  DataStoreBlobStore dbs=new DataStoreBlobStore(fds);
  nodeStore=getNodeStore(dbs);
  Blob b1=testCreateAndRead(createBlob(fds.getMinRecordLength() - 2));
  assertTrue(b1 instanceof SegmentBlob);
  assertNull(((SegmentBlob)b1).getBlobId());
  byte[] data2=new byte[Segment.MEDIUM_LIMIT + 1];
  new Random().nextBytes(data2);
  Blob b2=testCreateAndRead(nodeStore.createBlob(new ByteArrayInputStream(data2)));
  assertTrue(b2 instanceof SegmentBlob);
  assertNotNull(b2.getReference());
  InputStream is=dbs.getInputStream(((SegmentBlob)b2).getBlobId());
  assertNotNull(IOUtils.contentEquals(new ByteArrayInputStream(data2),is));
  is.close();
}
