@Test public void shouldCreateBaseWroManagerFactoryByDefault(){
  victim.contextInitialized(mockServletContextEvent);
  Assert.assertEquals(DefaultWroManagerFactory.class,AbstractDecorator.getOriginalDecoratedObject(victim.getManagerFactory()).getClass());
}
