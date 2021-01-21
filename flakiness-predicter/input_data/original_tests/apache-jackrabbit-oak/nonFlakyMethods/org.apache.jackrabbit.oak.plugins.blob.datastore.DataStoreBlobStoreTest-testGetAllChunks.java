@Test public void testGetAllChunks() throws Exception {
  DataIdentifier d10=new DataIdentifier("d-10");
  DataIdentifier d20=new DataIdentifier("d-20");
  DataIdentifier d30=new DataIdentifier("d-30");
  List<DataIdentifier> dis=ImmutableList.of(d10,d20,d30);
  DataStore mockedDS=mock(DataStore.class);
  when(mockedDS.getAllIdentifiers()).thenReturn(dis.iterator());
  when(mockedDS.getRecord(new DataIdentifier("d-10"))).thenReturn(new TimeDataRecord(d10));
  when(mockedDS.getRecord(new DataIdentifier("d-20"))).thenReturn(new TimeDataRecord(d20));
  when(mockedDS.getRecord(new DataIdentifier("d-30"))).thenReturn(new TimeDataRecord(d30));
  DataStoreBlobStore ds=new DataStoreBlobStore(mockedDS);
  Iterator<String> chunks=ds.getAllChunkIds(25);
  Set<String> expected=Sets.newHashSet("d-10","d-20");
  assertEquals(expected,Sets.newHashSet(chunks));
}
