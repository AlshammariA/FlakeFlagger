@Test public void testNonExistingPath() throws Exception {
  String path="some/path/to/oak:index/solrIdx";
  UpToDateNodeStateConfiguration upToDateNodeStateConfiguration=new UpToDateNodeStateConfiguration(store,path);
  assertNotNull(upToDateNodeStateConfiguration.getSolrServerConfiguration());
}
