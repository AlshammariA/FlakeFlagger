@Test(expected=NullPointerException.class) public void cannotUseNullArgument(){
  factory=new PropertiesAndFilterConfigWroConfigurationFactory(null){
    @Override protected Properties newDefaultProperties(){
      return null;
    }
  }
;
}
