@Test public void testHostnameOnlyDefaultPort(){
  CassandraHostConfigurator cassandraHostConfigurator=new CassandraHostConfigurator("localhost");
  CassandraHost[] cassandraHosts=cassandraHostConfigurator.buildCassandraHosts();
  assertEquals(CassandraHost.DEFAULT_PORT,cassandraHosts[0].getPort());
}
