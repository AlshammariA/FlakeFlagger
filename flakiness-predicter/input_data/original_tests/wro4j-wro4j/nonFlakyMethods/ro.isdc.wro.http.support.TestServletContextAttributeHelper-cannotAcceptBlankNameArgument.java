@Test(expected=IllegalArgumentException.class) public void cannotAcceptBlankNameArgument(){
  victim=new ServletContextAttributeHelper(mockServletContext,"   ");
}
