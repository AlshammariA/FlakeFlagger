@Test public void defaultModelFactoryIsXml(){
  new BaseWroManagerFactory(){
    @Override protected WroModelFactory newModelFactory(){
      final WroModelFactory modelFactory=super.newModelFactory();
      assertEquals(SmartWroModelFactory.class,modelFactory.getClass());
      return modelFactory;
    }
  }
;
}
