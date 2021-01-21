@Test(expected=WroRuntimeException.class) public void cannotConfigureInvalidStrategy(){
  final Properties props=new Properties();
  props.setProperty(ConfigurableModelFactory.KEY,"Invalid");
  victim.setProperties(props);
  victim.getConfiguredStrategy();
}
