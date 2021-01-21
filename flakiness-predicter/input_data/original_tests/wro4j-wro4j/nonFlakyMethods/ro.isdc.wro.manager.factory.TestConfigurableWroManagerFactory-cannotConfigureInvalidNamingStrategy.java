@Test(expected=WroRuntimeException.class) public void cannotConfigureInvalidNamingStrategy() throws Exception {
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableNamingStrategy.KEY,"INVALID");
  victim.setConfigProperties(configProperties);
  victim.create().getNamingStrategy().rename("name",WroUtil.EMPTY_STREAM);
}
