@Test public void testGetRangeSlices() throws HectorException {
  for (int i=0; i < 10; i++) {
    ColumnPath cp=new ColumnPath("Standard2");
    cp.setColumn(bytes("testGetRangeSlices_" + i));
    keyspace.insert("testGetRangeSlices0",cp,StringSerializer.get().toByteBuffer("testGetRangeSlices_Value_" + i));
    keyspace.insert("testGetRangeSlices1",cp,StringSerializer.get().toByteBuffer("testGetRangeSlices_Value_" + i));
    keyspace.insert("testGetRangeSlices2",cp,StringSerializer.get().toByteBuffer("testGetRangeSlices_Value_" + i));
  }
  ColumnParent clp=new ColumnParent("Standard2");
  SliceRange sr=new SliceRange(ByteBuffer.wrap(new byte[0]),ByteBuffer.wrap(new byte[0]),false,150);
  SlicePredicate sp=new SlicePredicate();
  sp.setSlice_range(sr);
  KeyRange range=new KeyRange();
  range.setStart_key("".getBytes());
  range.setEnd_key("".getBytes());
  Map<String,List<Column>> keySlices=se.fromBytesMap(keyspace.getRangeSlices(clp,sp,range));
  assertNotNull(keySlices);
  assertNotNull("testGetRangeSlices1 is null",keySlices.get("testGetRangeSlices1"));
  assertEquals("testGetRangeSlices_Value_0",string(keySlices.get("testGetRangeSlices1").get(0).getValue()));
  assertEquals(10,keySlices.get("testGetRangeSlices1").size());
  ColumnPath cp=new ColumnPath("Standard2");
  keyspace.remove("testGetRanageSlices0",cp);
  keyspace.remove("testGetRanageSlices1",cp);
  keyspace.remove("testGetRanageSlices2",cp);
}
