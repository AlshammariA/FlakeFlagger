@Test(expected=IllegalArgumentException.class) public void cannotAcceptEmptyNameArgument(){
  victim=new ServletContextAttributeHelper(mockServletContext,"");
}
