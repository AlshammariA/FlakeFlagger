@Test(expected=NullPointerException.class) public void cannotSetNullLocatorStrategy(){
  victim.setLocatorStrategy(null);
}
