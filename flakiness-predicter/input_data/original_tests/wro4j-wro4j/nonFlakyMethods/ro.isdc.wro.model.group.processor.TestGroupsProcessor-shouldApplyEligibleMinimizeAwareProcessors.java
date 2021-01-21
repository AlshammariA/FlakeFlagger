@Test public void shouldApplyEligibleMinimizeAwareProcessors() throws Exception {
  final JSMinProcessor cssMinProcessor=Mockito.spy(new JSMinProcessor());
  final BaseWroManagerFactory managerFactory=new BaseWroManagerFactory();
  managerFactory.setProcessorsFactory(new SimpleProcessorsFactory().addPostProcessor(cssMinProcessor));
  managerFactory.setModelFactory(WroTestUtils.simpleModelFactory(new WroModel().addGroup(new Group("g1").addResource(Resource.create("/script.js")))));
  initVictim(new WroConfiguration(),managerFactory);
  victim.process(new CacheKey("g1",ResourceType.JS,true));
  verify(cssMinProcessor).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
