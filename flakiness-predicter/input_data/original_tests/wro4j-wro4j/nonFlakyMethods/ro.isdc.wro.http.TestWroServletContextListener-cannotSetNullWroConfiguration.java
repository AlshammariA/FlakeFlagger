@Test(expected=NullPointerException.class) public void cannotSetNullWroConfiguration(){
  victim.setConfiguration(null);
}
