@Test public void shouldUseOverridenManagerFactory(){
  final WroManagerFactory managerFactory=new BaseWroManagerFactory();
  victim=new WroServletContextListener(){
    @Override protected WroManagerFactory newManagerFactory(){
      return managerFactory;
    }
  }
;
  victim.contextInitialized(mockServletContextEvent);
  Assert.assertSame(managerFactory,AbstractDecorator.getOriginalDecoratedObject(victim.getManagerFactory()));
}
