@Test(expected=NullPointerException.class) public void cannotCreateGroupWithNullName(){
  new Group(null);
}
