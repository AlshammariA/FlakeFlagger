@Test(expected=IllegalStateException.class) public void testGetCassandraNotOpen(){
  hThriftClient.getCassandra();
}
