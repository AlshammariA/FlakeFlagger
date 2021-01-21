@Test public void testMultigetCount(){
  List<ByteBuffer> keys=new ArrayList<ByteBuffer>();
  for (int j=0; j < 10; j++) {
    for (int i=0; i < 25; i++) {
      ColumnPath cp=new ColumnPath("Standard1");
      cp.setColumn(StringSerializer.get().toByteBuffer("testMultigetCount_column_" + i));
      keyspace.insert("testMultigetCount_key_" + j,cp,StringSerializer.get().toByteBuffer("testMultigetCount_value_" + i));
    }
    if (j % 2 == 0) {
      keys.add(StringSerializer.get().toByteBuffer("testMultigetCount_key_" + j));
    }
  }
  ColumnParent clp=new ColumnParent("Standard1");
  SlicePredicate slicePredicate=new SlicePredicate();
  SliceRange sr=new SliceRange(ByteBuffer.wrap(new byte[0]),ByteBuffer.wrap(new byte[0]),false,150);
  slicePredicate.setSlice_range(sr);
  Map<ByteBuffer,Integer> counts=keyspace.multigetCount(keys,clp,slicePredicate);
  assertEquals(5,counts.size());
  assertEquals(new Integer(25),counts.entrySet().iterator().next().getValue());
  slicePredicate.setSlice_range(new SliceRange(StringSerializer.get().toByteBuffer(""),StringSerializer.get().toByteBuffer(""),false,5));
  counts=keyspace.multigetCount(keys,clp,slicePredicate);
  assertEquals(5,counts.size());
  assertEquals(new Integer(5),counts.entrySet().iterator().next().getValue());
}
