@Test public void testSimpleCassandraHostSetup(){
  CassandraHostConfigurator cassandraHostConfigurator=new CassandraHostConfigurator("localhost:9170");
  CassandraHost[] cassandraHosts=cassandraHostConfigurator.buildCassandraHosts();
  assertEquals(1,cassandraHosts.length);
}
