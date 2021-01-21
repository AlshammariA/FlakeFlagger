@Test public void testGetSuperRangeSlices() throws HectorException {
  for (int i=0; i < 10; i++) {
    ColumnPath cp=new ColumnPath("Super1");
    cp.setSuper_column(bytes("SuperColumn_1"));
    cp.setColumn(bytes("testGetSuperRangeSlices_" + i));
    keyspace.insert("testGetSuperRangeSlices0",cp,StringSerializer.get().toByteBuffer("testGetSuperRangeSlices_Value_" + i));
    keyspace.insert("testGetSuperRangeSlices1",cp,StringSerializer.get().toByteBuffer("testGetSuperRangeSlices_Value_" + i));
  }
  ColumnParent clp=new ColumnParent("Super1");
  SliceRange sr=new SliceRange(ByteBuffer.wrap(new byte[0]),ByteBuffer.wrap(new byte[0]),false,150);
  SlicePredicate sp=new SlicePredicate();
  sp.setSlice_range(sr);
  KeyRange range=new KeyRange();
  range.setStart_key("".getBytes());
  range.setEnd_key("".getBytes());
  Map<String,List<SuperColumn>> keySlices=se.fromBytesMap(keyspace.getSuperRangeSlices(clp,sp,range));
  assertNotNull(keySlices);
  assertNotNull("testGetSuperRangSlices0 is null",keySlices.get("testGetSuperRangeSlices0"));
  assertEquals("testGetSuperRangeSlices_Value_0",string(keySlices.get("testGetSuperRangeSlices0").get(0).getColumns().get(0).getValue()));
  assertEquals(1,keySlices.get("testGetSuperRangeSlices1").size());
  assertEquals(10,keySlices.get("testGetSuperRangeSlices1").get(0).getColumns().size());
  ColumnPath cp=new ColumnPath("Super1");
  keyspace.remove("testGetSuperRangeSlices0",cp);
  keyspace.remove("testGetSuperRangeSlices1",cp);
}
