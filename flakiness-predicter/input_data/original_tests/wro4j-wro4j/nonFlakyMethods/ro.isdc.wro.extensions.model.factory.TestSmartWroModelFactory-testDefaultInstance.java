@Test(expected=WroRuntimeException.class) public void testDefaultInstance() throws Exception {
  factory=new SmartWroModelFactory();
  injector.inject(factory);
  factory.create();
}
