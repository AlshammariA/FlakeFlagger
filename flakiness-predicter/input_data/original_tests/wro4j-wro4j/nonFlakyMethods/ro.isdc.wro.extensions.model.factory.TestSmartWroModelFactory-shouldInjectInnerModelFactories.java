/** 
 * Checks that modelFactories provided as a list will have all required fields injected (ex: locatorFactory)
 */
@Test public void shouldInjectInnerModelFactories(){
  final SmartWroModelFactory factory=new SmartWroModelFactory(){
    @Override protected List<WroModelFactory> newWroModelFactoryFactoryList(){
      final List<WroModelFactory> list=new ArrayList<WroModelFactory>();
      list.add(new CustomWroModel(){
        @Override public WroModel create(){
          Assert.assertNotNull("Should have an injected locator!",uriLocatorFactory);
          return new WroModel();
        }
      }
);
      return list;
    }
  }
;
  injector.inject(factory);
  Assert.assertNotNull(factory.create());
}
