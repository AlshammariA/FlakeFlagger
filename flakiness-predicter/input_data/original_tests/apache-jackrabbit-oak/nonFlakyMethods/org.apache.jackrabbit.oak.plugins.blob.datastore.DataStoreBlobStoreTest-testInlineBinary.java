@Test public void testInlineBinary() throws DataStoreException, IOException {
  int maxInlineSize=300;
  DataStore mockedDS=mock(DataStore.class);
  when(mockedDS.getMinRecordLength()).thenReturn(maxInlineSize);
  DataStoreBlobStore ds=new DataStoreBlobStore(mockedDS);
  byte[] data=new byte[maxInlineSize];
  new Random().nextBytes(data);
  DataRecord dr=ds.addRecord(new ByteArrayInputStream(data));
  assertTrue(InMemoryDataRecord.isInstance(dr.getIdentifier().toString()));
  assertTrue(IOUtils.contentEquals(new ByteArrayInputStream(data),dr.getStream()));
  assertTrue(IOUtils.contentEquals(new ByteArrayInputStream(data),new BlobStoreInputStream(ds,dr.getIdentifier().toString(),0)));
  assertEquals(dr,ds.getRecordIfStored(dr.getIdentifier()));
  assertEquals(dr,ds.getRecord(dr.getIdentifier()));
  assertEquals(maxInlineSize,ds.getBlobLength(dr.getIdentifier().toString()));
  assertEquals(dr.getIdentifier().toString(),BlobId.of(ds.writeBlob(new ByteArrayInputStream(data))).blobId);
}
