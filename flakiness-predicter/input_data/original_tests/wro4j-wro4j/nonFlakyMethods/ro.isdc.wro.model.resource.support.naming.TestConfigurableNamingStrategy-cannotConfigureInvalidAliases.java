@Test(expected=WroRuntimeException.class) public void cannotConfigureInvalidAliases(){
  victim.setProperties(buildPropsForAlias(NoOpNamingStrategy.ALIAS + ", invalidOne"));
  victim.getConfiguredStrategy();
}
