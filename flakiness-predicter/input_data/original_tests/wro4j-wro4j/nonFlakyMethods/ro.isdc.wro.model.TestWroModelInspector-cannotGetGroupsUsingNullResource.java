@Test(expected=NullPointerException.class) public void cannotGetGroupsUsingNullResource(){
  victim.getGroupNamesContainingResource(null);
}
