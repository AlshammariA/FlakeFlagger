@Test public void testRemoveHost(){
  CassandraHost cassandraHost=new CassandraHost("127.0.0.1",9170);
  connectionManager.removeCassandraHost(cassandraHost);
  assertEquals(0,connectionManager.getActivePools().size());
  assertTrue(connectionManager.addCassandraHost(cassandraHost));
  assertEquals(1,connectionManager.getActivePools().size());
}
