/** 
 * TODO Implement
 */
@Test(expected=WroRuntimeException.class) public void cannotConfigureInvalidRequestHandler() throws Exception {
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableCacheStrategy.KEY,"INVALID");
  victim.setConfigProperties(configProperties);
  victim.create().getCacheStrategy().clear();
}
