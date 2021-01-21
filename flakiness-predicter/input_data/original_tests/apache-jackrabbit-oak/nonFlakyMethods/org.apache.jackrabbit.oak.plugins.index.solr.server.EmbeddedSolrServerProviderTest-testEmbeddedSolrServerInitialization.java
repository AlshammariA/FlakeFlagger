@Test public void testEmbeddedSolrServerInitialization() throws Exception {
  EmbeddedSolrServerConfiguration solrServerConfiguration=new EmbeddedSolrServerConfiguration(getClass().getResource("/solr").getFile(),getClass().getResource("/solr/solr.xml").getFile(),"oak");
  EmbeddedSolrServerProvider embeddedSolrServerProvider=new EmbeddedSolrServerProvider(solrServerConfiguration);
  SolrServer solrServer=embeddedSolrServerProvider.getSolrServer();
  assertNotNull(solrServer);
  SolrPingResponse ping=solrServer.ping();
  assertNotNull(ping);
  assertEquals(0,ping.getStatus());
}
