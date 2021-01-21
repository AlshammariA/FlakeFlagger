@Test public void testCreateRemoteServerFromConfig() throws Exception {
  SolrServerConfiguration<RemoteSolrServerProvider> remoteSolrServerProviderSolrServerConfiguration=new RemoteSolrServerConfiguration(null,null,1,1,null);
  RemoteSolrServerProvider remoteSolrServerProvider=remoteSolrServerProviderSolrServerConfiguration.getProvider();
  assertNotNull(remoteSolrServerProvider);
}
