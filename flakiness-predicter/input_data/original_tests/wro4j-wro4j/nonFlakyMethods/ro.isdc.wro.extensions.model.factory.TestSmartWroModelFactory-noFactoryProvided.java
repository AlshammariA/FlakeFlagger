@Test(expected=WroRuntimeException.class) public void noFactoryProvided() throws Exception {
  final List<WroModelFactory> list=Collections.emptyList();
  factory=new SmartWroModelFactory().setFactoryList(list);
  injector.inject(factory);
  factory.create();
}
