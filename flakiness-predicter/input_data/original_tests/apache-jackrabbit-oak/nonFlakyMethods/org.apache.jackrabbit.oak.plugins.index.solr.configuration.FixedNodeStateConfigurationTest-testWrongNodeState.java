@Test public void testWrongNodeState() throws Exception {
  NodeState idxDef=store.getRoot().getChildNode("a");
  FixedNodeStateConfiguration fixedNodeStateConfiguration=new FixedNodeStateConfiguration(idxDef);
  assertFalse(fixedNodeStateConfiguration.getConfigurationNodeState().exists());
  assertNotNull(fixedNodeStateConfiguration.getSolrServerConfiguration());
}
