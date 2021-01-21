@Test public void shouldConsiderContributeMethodsWhenManagerFactoryIsExtended(){
  final String alias="contributed";
  victim=new ConfigurableWroManagerFactory(){
    @Override protected void contributePreProcessors(    final Map<String,ResourcePreProcessor> map){
      map.put(alias,new JSMinProcessor());
    }
    @Override protected void contributePostProcessors(    final Map<String,ResourcePostProcessor> map){
      map.put(alias,new JSMinProcessor());
    }
    @Override protected void contributeLocators(    final Map<String,UriLocator> map){
      map.put(alias,new UrlUriLocator());
    }
  }
;
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS,alias);
  configProperties.setProperty(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS,alias);
  configProperties.setProperty(ConfigurableLocatorFactory.PARAM_URI_LOCATORS,alias);
  victim.setConfigProperties(configProperties);
  final WroManager manager=victim.create();
  assertFalse(manager.getProcessorsFactory().getPostProcessors().isEmpty());
  assertFalse(manager.getProcessorsFactory().getPreProcessors().isEmpty());
}
