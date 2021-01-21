@Test public void testHostnameOnlyDefaultPortMultipleHosts(){
  CassandraHostConfigurator cassandraHostConfigurator=new CassandraHostConfigurator("h1,h2,h3:1111");
  CassandraHost[] cassandraHosts=cassandraHostConfigurator.buildCassandraHosts();
  assertEquals(CassandraHost.DEFAULT_PORT,cassandraHosts[0].getPort());
  assertEquals(CassandraHost.DEFAULT_PORT,cassandraHosts[1].getPort());
  assertEquals(1111,cassandraHosts[2].getPort());
}
