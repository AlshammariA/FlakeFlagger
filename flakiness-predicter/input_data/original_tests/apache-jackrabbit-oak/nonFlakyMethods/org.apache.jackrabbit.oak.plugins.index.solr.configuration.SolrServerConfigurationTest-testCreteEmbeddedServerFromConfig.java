@Test public void testCreteEmbeddedServerFromConfig() throws Exception {
  SolrServerConfiguration<EmbeddedSolrServerProvider> embeddedSolrServerSolrServerConfiguration=new EmbeddedSolrServerConfiguration(null,null,null);
  EmbeddedSolrServerProvider embeddedSolrServerProvider=embeddedSolrServerSolrServerConfiguration.getProvider();
  assertNotNull(embeddedSolrServerProvider);
}
