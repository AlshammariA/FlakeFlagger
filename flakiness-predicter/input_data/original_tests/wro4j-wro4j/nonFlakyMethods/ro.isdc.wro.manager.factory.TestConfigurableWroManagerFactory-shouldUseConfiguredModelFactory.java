@Test public void shouldUseConfiguredModelFactory() throws Exception {
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableModelFactory.KEY,XmlModelFactory.ALIAS);
  victim.setConfigProperties(configProperties);
  final WroModelFactory actual=((ConfigurableModelFactory)AbstractDecorator.getOriginalDecoratedObject(victim.create().getModelFactory())).getConfiguredStrategy();
  assertEquals(XmlModelFactory.class,actual.getClass());
}
