@Test public void testSetRuntimeCl(){
  configurableConsistencyLevel.setConsistencyLevelForCfOperation(HConsistencyLevel.ANY,"OtherCf",OperationType.READ);
  assertEquals(HConsistencyLevel.ANY,configurableConsistencyLevel.get(OperationType.READ,"OtherCf"));
}
