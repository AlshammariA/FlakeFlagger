@Test public void shouldApplyOnlyEligibleProcessors() throws Exception {
  final CssMinProcessor cssMinProcessor=Mockito.spy(new CssMinProcessor());
  final BaseWroManagerFactory managerFactory=new BaseWroManagerFactory();
  managerFactory.setProcessorsFactory(new SimpleProcessorsFactory().addPostProcessor(cssMinProcessor));
  managerFactory.setModelFactory(WroTestUtils.simpleModelFactory(new WroModel().addGroup(new Group("g1").addResource(Resource.create("/script.js")))));
  initVictim(new WroConfiguration(),managerFactory);
  victim.process(new CacheKey("g1",ResourceType.JS,true));
  verify(cssMinProcessor,Mockito.never()).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
