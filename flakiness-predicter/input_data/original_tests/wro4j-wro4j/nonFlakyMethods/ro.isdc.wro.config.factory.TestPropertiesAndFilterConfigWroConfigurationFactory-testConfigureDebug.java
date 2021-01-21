@Test public void testConfigureDebug(){
  Mockito.when(filterConfig.getInitParameter(ConfigConstants.debug.name())).thenReturn("false");
  final WroConfiguration config=factory.create();
  Assert.assertEquals(false,config.isDebug());
}
