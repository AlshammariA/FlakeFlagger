@Test(expected=NullPointerException.class) public void cannotExtractGroupNamesUsingNullUri(){
  victim.getGroupName(null);
}
