@Test(expected=NullPointerException.class) public void cannotAcceptNullKey(){
  victim.get(null);
}
