@Test(expected=NullPointerException.class) public void cannotAcceptNullCssUri(){
  victim.rewrite(null,DEFAULT_IMAGE_URL);
}
