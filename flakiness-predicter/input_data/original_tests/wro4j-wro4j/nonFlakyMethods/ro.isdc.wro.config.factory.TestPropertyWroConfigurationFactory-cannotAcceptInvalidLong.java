@Test(expected=WroRuntimeException.class) public void cannotAcceptInvalidLong(){
  final Properties props=new Properties();
  props.setProperty(ConfigConstants.cacheUpdatePeriod.name(),"INVALID_LONG");
  factory=new PropertyWroConfigurationFactory(props);
  factory.create();
}
