@Test(expected=NullPointerException.class) public void cannotAcceptNullArgument(){
  new ReloadModelRunnable(null);
}
