@Test public void shouldCreateConfigOverridenPath(){
  victim=new ServletContextPropertyWroConfigurationFactory(mockServletContext){
    @Override protected String getConfigPath(){
      return "/path/to/another/config.properties";
    }
  }
;
  Assert.assertNotNull(victim.create());
}
