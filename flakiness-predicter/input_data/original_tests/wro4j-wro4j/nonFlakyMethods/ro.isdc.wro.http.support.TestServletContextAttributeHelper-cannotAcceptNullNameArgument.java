@Test(expected=NullPointerException.class) public void cannotAcceptNullNameArgument(){
  victim=new ServletContextAttributeHelper(mockServletContext,null);
}
