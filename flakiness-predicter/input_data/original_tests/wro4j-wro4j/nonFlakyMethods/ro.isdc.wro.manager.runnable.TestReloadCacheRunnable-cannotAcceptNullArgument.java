@Test(expected=NullPointerException.class) public void cannotAcceptNullArgument(){
  new ReloadCacheRunnable(null);
}
