@Test public void testGetSetPredicate_range(){
  ConcreteSliceQueury<String,String,String,Rows<String,String,String>> q=new ConcreteSliceQueury<String,String,String,Rows<String,String,String>>(ko,se,se,se);
  q.setRange("1","100",false,10);
  SlicePredicate p=q.getPredicate();
  assertNull(p.getColumn_names());
  SliceRange range=p.getSlice_range();
  assertNotNull(range);
  assertArrayEquals(bytes("1"),range.getStart());
  assertArrayEquals(bytes("100"),range.getFinish());
  assertEquals(10,range.getCount());
}
