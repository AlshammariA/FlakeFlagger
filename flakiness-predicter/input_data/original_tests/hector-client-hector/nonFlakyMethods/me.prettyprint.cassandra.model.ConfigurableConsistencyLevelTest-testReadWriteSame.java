@Test public void testReadWriteSame(){
  assertEquals(HConsistencyLevel.ONE,configurableConsistencyLevel.get(OperationType.READ,"MyColumnFamily"));
}
