@Test(expected=WroRuntimeException.class) public void cannotSetInvalidLocatorAlias(){
  final Properties props=createPropsWithLocators("invalid");
  victim.setProperties(props);
  victim.getConfiguredStrategies();
}
