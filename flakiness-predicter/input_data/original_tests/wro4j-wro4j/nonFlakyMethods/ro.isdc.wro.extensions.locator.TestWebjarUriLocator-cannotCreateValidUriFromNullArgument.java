@Test(expected=NullPointerException.class) public void cannotCreateValidUriFromNullArgument(){
  WebjarUriLocator.createUri(null);
}
