@Test public void shouldUseTheWroManagerSet(){
  final WroManagerFactory managerFactory=new BaseWroManagerFactory();
  victim.setManagerFactory(managerFactory);
  victim.contextInitialized(mockServletContextEvent);
  Assert.assertSame(managerFactory,AbstractDecorator.getOriginalDecoratedObject(victim.getManagerFactory()));
}
