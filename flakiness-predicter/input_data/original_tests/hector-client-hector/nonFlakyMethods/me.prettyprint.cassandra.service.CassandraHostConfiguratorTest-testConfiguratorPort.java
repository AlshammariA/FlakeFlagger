@Test public void testConfiguratorPort(){
  CassandraHostConfigurator cassandraHostConfigurator=new CassandraHostConfigurator("localhost");
  cassandraHostConfigurator.setPort(9177);
  CassandraHost[] cassandraHosts=cassandraHostConfigurator.buildCassandraHosts();
  assertEquals(9177,cassandraHosts[0].getPort());
}
