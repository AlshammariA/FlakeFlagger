@Test(expected=WroRuntimeException.class) public void cannotConfigureInvalidHashStrategy() throws Exception {
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableHashStrategy.KEY,"INVALID");
  victim.setConfigProperties(configProperties);
  victim.create().getHashStrategy().getHash(WroUtil.EMPTY_STREAM);
}
