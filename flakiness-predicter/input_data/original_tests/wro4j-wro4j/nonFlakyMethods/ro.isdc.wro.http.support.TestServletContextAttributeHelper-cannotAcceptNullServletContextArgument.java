@Test(expected=NullPointerException.class) public void cannotAcceptNullServletContextArgument(){
  victim=new ServletContextAttributeHelper(null,"value");
}
