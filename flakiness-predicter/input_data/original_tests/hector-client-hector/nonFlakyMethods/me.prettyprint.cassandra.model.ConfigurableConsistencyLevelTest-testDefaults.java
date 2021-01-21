@Test public void testDefaults(){
  configurableConsistencyLevel.setDefaultWriteConsistencyLevel(HConsistencyLevel.ALL);
  configurableConsistencyLevel.setWriteCfConsistencyLevels(new HashMap<String,HConsistencyLevel>());
  assertEquals(HConsistencyLevel.ALL,configurableConsistencyLevel.get(OperationType.WRITE,"MyColumnFamily"));
}
