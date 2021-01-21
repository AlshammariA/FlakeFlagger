@Test(expected=WroRuntimeException.class) public void cannotUseInvalidConfiguredModelFactory() throws Exception {
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableModelFactory.KEY,"invalid");
  victim.setConfigProperties(configProperties);
  ((ConfigurableModelFactory)AbstractDecorator.getOriginalDecoratedObject(victim.create().getModelFactory())).getConfiguredStrategy();
}
