@Test public void testBatchUpdateInsertAndDelOnSame() throws HectorException {
  ColumnPath sta1=new ColumnPath("Standard1");
  sta1.setColumn(bytes("deleteThroughInserBatch_col"));
  keyspace.insert("deleteThroughInserBatch_key",sta1,StringSerializer.get().toByteBuffer("deleteThroughInserBatch_val"));
  Column found=keyspace.getColumn("deleteThroughInserBatch_key",sta1);
  assertNotNull(found);
  BatchMutation<String> batchMutation=new BatchMutation<String>(StringSerializer.get());
  List<String> columnFamilies=Arrays.asList("Standard1");
  for (int i=0; i < 10; i++) {
    for (int j=0; j < 10; j++) {
      Column col=new Column(StringSerializer.get().toByteBuffer("testBatchMutateColumn_" + j),StringSerializer.get().toByteBuffer("testBatchMutateColumn_value_" + j),connectionManager.createClock());
      batchMutation.addInsertion("testBatchMutateColumn_" + i,columnFamilies,col);
    }
  }
  SlicePredicate slicePredicate=new SlicePredicate();
  slicePredicate.addToColumn_names(StringSerializer.get().toByteBuffer("deleteThroughInserBatch_col"));
  Deletion deletion=new Deletion(connectionManager.createClock());
  deletion.setPredicate(slicePredicate);
  batchMutation.addDeletion("deleteThroughInserBatch_key",columnFamilies,deletion);
  keyspace.batchMutate(batchMutation);
  try {
    keyspace.getColumn("deleteThroughInserBatch_key",sta1);
    fail("Should not have found a value here");
  }
 catch (  Exception e) {
  }
  for (int i=0; i < 10; i++) {
    for (int j=0; j < 10; j++) {
      ColumnPath cp=new ColumnPath("Standard1");
      cp.setColumn(bytes("testBatchMutateColumn_" + j));
      Column col=keyspace.getColumn("testBatchMutateColumn_" + i,cp);
      assertNotNull(col);
      String value=string(col.getValue());
      assertEquals("testBatchMutateColumn_value_" + j,value);
    }
  }
}
