@Test public void testExistingPath() throws Exception {
  NodeState idxDef=store.getRoot().getChildNode("oak:index").getChildNode("solrIdx");
  FixedNodeStateConfiguration fixedNodeStateConfiguration=new FixedNodeStateConfiguration(idxDef);
  EmbeddedSolrServerConfiguration solrServerConfiguration=(EmbeddedSolrServerConfiguration)fixedNodeStateConfiguration.getSolrServerConfiguration();
  assertNotNull(solrServerConfiguration);
  assertEquals("sh",solrServerConfiguration.getSolrHomePath());
  assertEquals("cn",solrServerConfiguration.getCoreName());
  assertEquals("sc",solrServerConfiguration.getSolrConfigPath());
  assertEquals("path_exact",fixedNodeStateConfiguration.getPathField());
}
