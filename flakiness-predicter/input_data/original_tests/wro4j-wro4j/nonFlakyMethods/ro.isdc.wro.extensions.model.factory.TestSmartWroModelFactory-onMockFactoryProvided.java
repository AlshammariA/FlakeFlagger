@Test public void onMockFactoryProvided() throws Exception {
  final WroModelFactory mockFactory=Mockito.mock(WroModelFactory.class);
  final List<WroModelFactory> list=Arrays.asList(mockFactory);
  factory=new SmartWroModelFactory().setFactoryList(list);
  injector.inject(factory);
  Assert.assertNull(factory.create());
}
