@Test public void testExternalBinary() throws DataStoreException, IOException {
  int maxInlineSize=300;
  int actualSize=maxInlineSize + 10;
  byte[] data=new byte[actualSize];
  new Random().nextBytes(data);
  DataIdentifier testDI=new DataIdentifier("test");
  DataRecord testDR=new ByteArrayDataRecord(data,testDI,"testReference");
  DataStore mockedDS=mock(DataStore.class);
  when(mockedDS.getMinRecordLength()).thenReturn(maxInlineSize);
  when(mockedDS.getRecord(testDI)).thenReturn(testDR);
  when(mockedDS.getRecordIfStored(testDI)).thenReturn(testDR);
  when(mockedDS.addRecord(any(InputStream.class))).thenReturn(testDR);
  DataStoreBlobStore ds=new DataStoreBlobStore(mockedDS);
  DataRecord dr=ds.addRecord(new ByteArrayInputStream(data));
  assertFalse(InMemoryDataRecord.isInstance(dr.getIdentifier().toString()));
  assertEquals(testDI,dr.getIdentifier());
  assertTrue(IOUtils.contentEquals(new ByteArrayInputStream(data),dr.getStream()));
  assertTrue(IOUtils.contentEquals(new ByteArrayInputStream(data),new BlobStoreInputStream(ds,dr.getIdentifier().toString(),0)));
  assertEquals(dr,ds.getRecordIfStored(dr.getIdentifier()));
  assertEquals(dr,ds.getRecord(dr.getIdentifier()));
  assertEquals(actualSize,ds.getBlobLength(dr.getIdentifier().toString()));
  assertEquals(testDI.toString(),BlobId.of(ds.writeBlob(new ByteArrayInputStream(data))).blobId);
}
