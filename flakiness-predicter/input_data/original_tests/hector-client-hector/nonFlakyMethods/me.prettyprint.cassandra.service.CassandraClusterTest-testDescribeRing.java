@Test public void testDescribeRing() throws Exception {
  List<TokenRange> ring=cassandraCluster.describeRing("Keyspace1");
  assertEquals(1,ring.size());
}
