@Test public void onMockFactoryProvided2() throws Exception {
  final WroModelFactory mockFactory=Mockito.mock(WroModelFactory.class);
  Mockito.when(mockFactory.create()).thenReturn(new WroModel());
  final List<WroModelFactory> list=Arrays.asList(mockFactory);
  factory=new SmartWroModelFactory().setFactoryList(list);
  injector.inject(factory);
  Assert.assertNotNull(factory.create());
}
