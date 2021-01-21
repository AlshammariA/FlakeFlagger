@Test(expected=WroRuntimeException.class) public void cannotCreateModelWhenNullListOfFactoriesProvided() throws Exception {
  factory=new SmartWroModelFactory(){
    @Override protected List<WroModelFactory> newWroModelFactoryFactoryList(){
      return null;
    }
  }
;
  injector.inject(factory);
  factory.create();
}
