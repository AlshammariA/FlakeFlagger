@Test(expected=NullPointerException.class) public void cannotAcceptNullRunnable(){
  useNullRunnableWithPeriod(1);
}
