@Test public void testGetSlice() throws HectorException {
  ArrayList<String> columnnames=new ArrayList<String>(100);
  for (int i=0; i < 100; i++) {
    ColumnPath cp=new ColumnPath("Standard2");
    cp.setColumn(bytes("testGetSlice_" + i));
    keyspace.insert("testGetSlice",cp,StringSerializer.get().toByteBuffer("testGetSlice_Value_" + i));
    columnnames.add("testGetSlice_" + i);
  }
  ColumnParent clp=new ColumnParent("Standard2");
  SliceRange sr=new SliceRange(ByteBuffer.wrap(new byte[0]),ByteBuffer.wrap(new byte[0]),false,150);
  SlicePredicate sp=new SlicePredicate();
  sp.setSlice_range(sr);
  List<Column> cols=keyspace.getSlice("testGetSlice",clp,sp);
  assertNotNull(cols);
  assertEquals(100,cols.size());
  Collections.sort(columnnames);
  ArrayList<String> gotlist=new ArrayList<String>(100);
  for (int i=0; i < 100; i++) {
    gotlist.add(string(cols.get(i).getName()));
  }
  assertEquals(columnnames,gotlist);
  ColumnPath cp=new ColumnPath("Standard2");
  keyspace.remove("testGetSlice_",cp);
  keyspace.remove("testGetSlice",cp);
}
