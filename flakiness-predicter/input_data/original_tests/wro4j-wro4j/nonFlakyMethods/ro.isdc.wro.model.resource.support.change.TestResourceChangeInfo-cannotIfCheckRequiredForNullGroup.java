@Test(expected=NullPointerException.class) public void cannotIfCheckRequiredForNullGroup(){
  victim.isCheckRequiredForGroup(null);
}
