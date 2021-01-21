@Test public void testCassandraHostSetupSplit(){
  CassandraHostConfigurator cassandraHostConfigurator=new CassandraHostConfigurator("localhost:9170,localhost:9171,localhost:9172");
  CassandraHost[] cassandraHosts=cassandraHostConfigurator.buildCassandraHosts();
  assertEquals(3,cassandraHosts.length);
  assertEquals(9172,cassandraHosts[2].getPort());
}
