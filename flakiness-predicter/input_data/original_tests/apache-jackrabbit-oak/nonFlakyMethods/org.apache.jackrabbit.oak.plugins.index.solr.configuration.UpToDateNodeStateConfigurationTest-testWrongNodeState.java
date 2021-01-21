@Test public void testWrongNodeState() throws Exception {
  String path="a";
  UpToDateNodeStateConfiguration upToDateNodeStateConfiguration=new UpToDateNodeStateConfiguration(store,path);
  assertFalse(upToDateNodeStateConfiguration.getConfigurationNodeState().exists());
  assertNotNull(upToDateNodeStateConfiguration.getSolrServerConfiguration());
}
