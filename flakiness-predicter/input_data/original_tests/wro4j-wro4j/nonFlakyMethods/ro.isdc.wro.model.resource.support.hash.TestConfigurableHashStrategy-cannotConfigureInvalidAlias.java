@Test(expected=WroRuntimeException.class) public void cannotConfigureInvalidAlias(){
  victim.setProperties(buildPropsForAlias("invalidStrategy"));
  victim.getConfiguredStrategy();
}
