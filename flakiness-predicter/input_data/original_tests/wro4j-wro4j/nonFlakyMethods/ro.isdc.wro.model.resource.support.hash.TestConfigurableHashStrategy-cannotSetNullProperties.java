@Test(expected=NullPointerException.class) public void cannotSetNullProperties(){
  victim.setProperties(null);
}
