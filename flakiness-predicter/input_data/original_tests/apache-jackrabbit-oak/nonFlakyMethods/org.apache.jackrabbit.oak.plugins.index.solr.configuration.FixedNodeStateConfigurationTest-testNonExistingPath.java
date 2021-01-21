@Test public void testNonExistingPath() throws Exception {
  NodeState idxDef=store.getRoot().getChildNode("oak:index").getChildNode("a");
  FixedNodeStateConfiguration fixedNodeStateConfiguration=new FixedNodeStateConfiguration(idxDef);
  assertNotNull(fixedNodeStateConfiguration.getSolrServerConfiguration());
}
