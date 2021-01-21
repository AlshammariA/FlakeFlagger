@Test public void shouldBuildConfigurationEvenWhenDefaultPropertiesFileIsNotAvailable(){
  factory=new PropertiesAndFilterConfigWroConfigurationFactory(filterConfig){
    @Override protected Properties newDefaultProperties(){
      throw new WroRuntimeException("Cannot build default properties found");
    }
  }
;
  Assert.assertNotNull(factory.create());
}
