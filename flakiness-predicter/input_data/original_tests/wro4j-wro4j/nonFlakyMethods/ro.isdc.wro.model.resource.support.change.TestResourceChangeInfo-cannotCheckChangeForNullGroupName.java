@Test(expected=NullPointerException.class) public void cannotCheckChangeForNullGroupName(){
  victim.isChanged(null);
}
