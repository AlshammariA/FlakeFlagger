@Test(expected=IllegalArgumentException.class) public void cannotAcceptNullResponse(){
  new RedirectedStreamServletResponseWrapper(new ByteArrayOutputStream(),null);
}
