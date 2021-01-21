@Test public void shouldUseOverridenConfiguration(){
  final WroConfiguration configuration=new WroConfiguration();
  victim=new WroServletContextListener(){
    @Override protected WroConfiguration newConfiguration(){
      return configuration;
    }
  }
;
  victim.contextInitialized(mockServletContextEvent);
  Assert.assertSame(configuration,victim.getConfiguration());
}
