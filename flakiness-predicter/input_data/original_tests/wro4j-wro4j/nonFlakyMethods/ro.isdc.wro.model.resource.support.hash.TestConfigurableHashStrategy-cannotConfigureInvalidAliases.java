@Test(expected=WroRuntimeException.class) public void cannotConfigureInvalidAliases(){
  victim.setProperties(buildPropsForAlias(CRC32HashStrategy.ALIAS + ", invalidOne"));
  victim.getConfiguredStrategy();
}
