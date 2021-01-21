@Test public void testCostWithNoRestrictions() throws Exception {
  NodeState root=mock(NodeState.class);
  SelectorImpl selector=mock(SelectorImpl.class);
  SolrServer solrServer=mock(SolrServer.class);
  OakSolrConfiguration configuration=new DefaultSolrConfiguration();
  SolrQueryIndex solrQueryIndex=new SolrQueryIndex("solr",solrServer,configuration);
  FilterImpl filter=new FilterImpl(selector,"",new QueryEngineSettings());
  double cost=solrQueryIndex.getCost(filter,root);
  assertTrue(Double.POSITIVE_INFINITY == cost);
}
