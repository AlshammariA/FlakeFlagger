@Test public void testDescribePartitioner() throws Exception {
  String partitioner=cassandraCluster.describePartitioner();
  assertEquals("org.apache.cassandra.dht.OrderPreservingPartitioner",partitioner);
}
