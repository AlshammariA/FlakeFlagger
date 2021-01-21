@Test public void testMultigetSlice() throws HectorException {
  ColumnPath cp=new ColumnPath("Standard1");
  cp.setColumn(bytes("testMultigetSlice"));
  ArrayList<String> keys=new ArrayList<String>(100);
  for (int i=0; i < 100; i++) {
    keyspace.insert("testMultigetSlice_" + i,cp,StringSerializer.get().toByteBuffer("testMultigetSlice_value_" + i));
    keys.add("testMultigetSlice_" + i);
  }
  ColumnParent clp=new ColumnParent("Standard1");
  SliceRange sr=new SliceRange(ByteBuffer.wrap(new byte[0]),ByteBuffer.wrap(new byte[0]),false,150);
  SlicePredicate sp=new SlicePredicate();
  sp.setSlice_range(sr);
  Map<String,List<Column>> ms=se.fromBytesMap(keyspace.multigetSlice(se.toBytesList(keys),clp,sp));
  for (int i=0; i < 100; i++) {
    List<Column> cl=ms.get(keys.get(i));
    assertNotNull(cl);
    assertEquals(1,cl.size());
    assertTrue(string(cl.get(0).getValue()).startsWith("testMultigetSlice_"));
  }
  for (int i=0; i < 100; i++) {
    keyspace.remove("testMultigetSlice_" + i,cp);
  }
}
