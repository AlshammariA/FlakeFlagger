@Test public void testRepositoryService() throws Exception {
  Map<String,String> config=new HashMap<String,String>();
  config.put("org.apache.jackrabbit.repository.home",workDir.getAbsolutePath());
  config.put("org.apache.jackrabbit.oak.repository.configFile",path("oak-base-config.json") + "," + path("oak-tar-config.json"));
  Repository repository=JcrUtils.getRepository(config);
  assertNotNull(repository);
}
