@Test(expected=NullPointerException.class) public void cannotAcceptNullImageUrl(){
  victim.rewrite(DEFAULT_CSS_URI,null);
}
