@Test public void testExistingPath() throws Exception {
  String path="oak:index/solrIdx";
  UpToDateNodeStateConfiguration upToDateNodeStateConfiguration=new UpToDateNodeStateConfiguration(store,path);
  EmbeddedSolrServerConfiguration solrServerConfiguration=(EmbeddedSolrServerConfiguration)upToDateNodeStateConfiguration.getSolrServerConfiguration();
  assertNotNull(solrServerConfiguration);
  assertEquals("sh",solrServerConfiguration.getSolrHomePath());
  assertEquals("cn",solrServerConfiguration.getCoreName());
  assertEquals("sc",solrServerConfiguration.getSolrConfigPath());
  assertEquals("path_exact",upToDateNodeStateConfiguration.getPathField());
}
