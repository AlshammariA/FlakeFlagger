@Test public void shouldCreateWroManagerFactorySpecifiedByWroConfiguration(){
  victim.contextInitialized(mockServletContextEvent);
  Assert.assertEquals(DefaultWroManagerFactory.class,AbstractDecorator.getOriginalDecoratedObject(victim.getManagerFactory()).getClass());
}
