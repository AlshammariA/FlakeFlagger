@Test public void testEditKeyspace() throws Exception {
  BasicColumnFamilyDefinition columnFamilyDefinition=new BasicColumnFamilyDefinition();
  columnFamilyDefinition.setKeyspaceName("DynKeyspace2");
  columnFamilyDefinition.setName("DynamicCF");
  ColumnFamilyDefinition cfDef=new ThriftCfDef(columnFamilyDefinition);
  KeyspaceDefinition keyspaceDefinition=HFactory.createKeyspaceDefinition("DynKeyspace2","org.apache.cassandra.locator.SimpleStrategy",1,Arrays.asList(cfDef));
  cassandraCluster.addKeyspace(keyspaceDefinition);
  keyspaceDefinition=HFactory.createKeyspaceDefinition("DynKeyspace2","org.apache.cassandra.locator.SimpleStrategy",2,null);
  cassandraCluster.updateKeyspace(keyspaceDefinition);
  KeyspaceDefinition fromCluster=cassandraCluster.describeKeyspace("DynKeyspace2");
  assertEquals(2,fromCluster.getReplicationFactor());
  cassandraCluster.dropKeyspace("DynKeyspace2");
}
