@Test(expected=NullPointerException.class) public void cannotAddNullResource(){
  victim.add(null);
}
