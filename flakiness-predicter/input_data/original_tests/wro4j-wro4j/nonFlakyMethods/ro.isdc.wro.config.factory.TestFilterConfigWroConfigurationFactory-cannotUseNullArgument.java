@Test(expected=NullPointerException.class) public void cannotUseNullArgument(){
  factory=new FilterConfigWroConfigurationFactory(null);
}
