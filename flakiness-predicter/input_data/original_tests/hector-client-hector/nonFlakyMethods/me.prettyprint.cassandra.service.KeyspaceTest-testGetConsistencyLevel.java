@Test public void testGetConsistencyLevel(){
  assertEquals(HConsistencyLevel.QUORUM,keyspace.getConsistencyLevel(OperationType.READ));
}
