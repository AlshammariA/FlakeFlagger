@Test(expected=NullPointerException.class) public void cannotSetNullLints(){
  victim.setLints(null);
}
