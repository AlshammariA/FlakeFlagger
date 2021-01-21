@Test public void testReference() throws DataStoreException, IOException {
  String reference="testReference";
  String blobId="test";
  DataIdentifier testDI=new DataIdentifier(blobId);
  DataRecord testDR=new ByteArrayDataRecord("foo".getBytes(),testDI,reference);
  DataStore mockedDS=mock(DataStore.class);
  when(mockedDS.getRecordFromReference(reference)).thenReturn(testDR);
  when(mockedDS.getRecord(testDI)).thenReturn(testDR);
  DataStoreBlobStore ds=new DataStoreBlobStore(mockedDS);
  assertEquals(reference,ds.getReference(blobId));
  assertEquals(blobId,BlobId.of(ds.getBlobId(reference)).blobId);
  assertEquals(BlobId.of(testDR).encodedValue(),ds.getBlobId(reference));
  String inMemBlobId=InMemoryDataRecord.getInstance("foo".getBytes()).getIdentifier().toString();
  assertNull(ds.getReference(inMemBlobId));
}
