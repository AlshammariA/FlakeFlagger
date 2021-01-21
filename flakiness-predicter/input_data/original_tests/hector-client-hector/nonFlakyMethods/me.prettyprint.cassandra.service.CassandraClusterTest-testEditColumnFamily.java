@Test public void testEditColumnFamily() throws Exception {
  BasicColumnFamilyDefinition columnFamilyDefinition=new BasicColumnFamilyDefinition();
  columnFamilyDefinition.setKeyspaceName("DynKeyspace3");
  columnFamilyDefinition.setName("DynamicCF");
  ColumnFamilyDefinition cfDef=new ThriftCfDef(columnFamilyDefinition);
  KeyspaceDefinition keyspaceDefinition=HFactory.createKeyspaceDefinition("DynKeyspace3","org.apache.cassandra.locator.SimpleStrategy",1,Arrays.asList(cfDef));
  cassandraCluster.addKeyspace(keyspaceDefinition);
  KeyspaceDefinition fromCluster=cassandraCluster.describeKeyspace("DynKeyspace3");
  cfDef=fromCluster.getCfDefs().get(0);
  columnFamilyDefinition=new BasicColumnFamilyDefinition(cfDef);
  BasicColumnDefinition columnDefinition=new BasicColumnDefinition();
  columnDefinition.setName(StringSerializer.get().toByteBuffer("birthdate"));
  columnDefinition.setIndexType(ColumnIndexType.KEYS);
  columnDefinition.setValidationClass(ComparatorType.LONGTYPE.getClassName());
  columnFamilyDefinition.addColumnDefinition(columnDefinition);
  cassandraCluster.updateColumnFamily(new ThriftCfDef(columnFamilyDefinition));
  fromCluster=cassandraCluster.describeKeyspace("DynKeyspace3");
  assertEquals("birthdate",StringSerializer.get().fromByteBuffer(fromCluster.getCfDefs().get(0).getColumnMetadata().get(0).getName()));
}
