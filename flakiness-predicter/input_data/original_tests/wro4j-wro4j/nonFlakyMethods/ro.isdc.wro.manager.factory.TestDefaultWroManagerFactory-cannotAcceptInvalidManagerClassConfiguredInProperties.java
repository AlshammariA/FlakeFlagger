@Test(expected=WroRuntimeException.class) public void cannotAcceptInvalidManagerClassConfiguredInProperties(){
  final Properties props=propsForWroManagerClassName("invalid");
  new DefaultWroManagerFactory(props);
}
