@Test public void testGetSetPredicate_columnNames(){
  ConcreteSliceQueury<String,String,String,Rows<String,String,String>> q=new ConcreteSliceQueury<String,String,String,Rows<String,String,String>>(ko,se,se,se);
  q.setColumnNames("1","2","3");
  SlicePredicate p=q.getPredicate();
  assertEquals(3,p.getColumn_names().size());
  assertNull(p.getSlice_range());
}
