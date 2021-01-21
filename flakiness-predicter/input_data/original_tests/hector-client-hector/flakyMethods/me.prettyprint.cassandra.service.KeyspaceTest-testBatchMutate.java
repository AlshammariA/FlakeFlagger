@Test public void testBatchMutate() throws HectorException {
  Map<String,Map<String,List<Mutation>>> outerMutationMap=new HashMap<String,Map<String,List<Mutation>>>();
  for (int i=0; i < 10; i++) {
    Map<String,List<Mutation>> mutationMap=new HashMap<String,List<Mutation>>();
    ArrayList<Mutation> mutations=new ArrayList<Mutation>(10);
    for (int j=0; j < 10; j++) {
      Column col=new Column(StringSerializer.get().toByteBuffer("testBatchMutateColumn_" + j),StringSerializer.get().toByteBuffer("testBatchMutateColumn_value_" + j),connectionManager.createClock());
      ColumnOrSuperColumn cosc=new ColumnOrSuperColumn();
      cosc.setColumn(col);
      Mutation mutation=new Mutation();
      mutation.setColumn_or_supercolumn(cosc);
      mutations.add(mutation);
    }
    mutationMap.put("Standard1",mutations);
    outerMutationMap.put("testBatchMutateColumn_" + i,mutationMap);
  }
  keyspace.batchMutate(se.toBytesMap(outerMutationMap));
  outerMutationMap.clear();
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
  for (int i=0; i < 10; i++) {
    ArrayList<Mutation> mutations=new ArrayList<Mutation>(10);
    Map<String,List<Mutation>> mutationMap=new HashMap<String,List<Mutation>>();
    SlicePredicate slicePredicate=new SlicePredicate();
    for (int j=0; j < 10; j++) {
      slicePredicate.addToColumn_names(StringSerializer.get().toByteBuffer("testBatchMutateColumn_" + j));
    }
    Mutation mutation=new Mutation();
    Deletion deletion=new Deletion(connectionManager.createClock());
    deletion.setPredicate(slicePredicate);
    mutation.setDeletion(deletion);
    mutations.add(mutation);
    mutationMap.put("Standard1",mutations);
    outerMutationMap.put("testBatchMutateColumn_" + i,mutationMap);
  }
  keyspace.batchMutate(se.toBytesMap(outerMutationMap));
  for (int i=0; i < 10; i++) {
    for (int j=0; j < 10; j++) {
      ColumnPath cp=new ColumnPath("Standard1");
      cp.setColumn(bytes("testBatchMutateColumn_" + j));
      try {
        keyspace.getColumn("testBatchMutateColumn_" + i,cp);
        fail();
      }
 catch (      HNotFoundException e) {
      }
    }
  }
}
