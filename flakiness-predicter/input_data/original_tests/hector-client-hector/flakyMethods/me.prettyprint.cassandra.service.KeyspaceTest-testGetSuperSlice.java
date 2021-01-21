@Test public void testGetSuperSlice() throws HectorException {
  for (int i=0; i < 100; i++) {
    ColumnPath cp=new ColumnPath("Super1");
    cp.setSuper_column(bytes("SuperColumn_1"));
    cp.setColumn(bytes("testGetSuperSlice_" + i));
    ColumnPath cp2=new ColumnPath("Super1");
    cp2.setSuper_column(bytes("SuperColumn_2"));
    cp2.setColumn(bytes("testGetSuperSlice_" + i));
    keyspace.insert("testGetSuperSlice",cp,StringSerializer.get().toByteBuffer("testGetSuperSlice_Value_" + i));
    keyspace.insert("testGetSuperSlice",cp2,StringSerializer.get().toByteBuffer("testGetSuperSlice_Value_" + i));
  }
  ColumnParent clp=new ColumnParent("Super1");
  SliceRange sr=new SliceRange(ByteBuffer.wrap(new byte[0]),ByteBuffer.wrap(new byte[0]),false,150);
  SlicePredicate sp=new SlicePredicate();
  sp.setSlice_range(sr);
  List<SuperColumn> cols=keyspace.getSuperSlice("testGetSuperSlice",clp,sp);
  assertNotNull(cols);
  assertEquals(2,cols.size());
  ColumnPath cp=new ColumnPath("Super1");
  keyspace.remove("testGetSuperSlice",cp);
}
