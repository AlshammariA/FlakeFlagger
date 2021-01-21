@Test public void testCloudRemoteServerCreation() throws Exception {
  for (  String host : zkHosts) {
    boolean cloudServerAvailable=false;
    try {
      cloudServerAvailable=canCreateCollections(host);
    }
 catch (    Exception e) {
    }
    if (cloudServerAvailable) {
      String collection="sample_" + System.nanoTime();
      RemoteSolrServerProvider remoteSolrServerProvider=new RemoteSolrServerProvider(new RemoteSolrServerConfiguration(host,collection,2,2,null));
      SolrServer solrServer=remoteSolrServerProvider.getSolrServer();
      assertNotNull(solrServer);
      solrServer.shutdown();
      break;
    }
  }
}
