@Test(expected=NullPointerException.class) public void cannotAcceptNullArgument(){
  new ServletContextPropertyWroConfigurationFactory(null);
}
