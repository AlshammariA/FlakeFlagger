@Test(expected=NullPointerException.class) public void cannotAcceptNullStream(){
  new RedirectedStreamServletResponseWrapper(null,mockResponse);
}
