@Test(expected=NullPointerException.class) public void cannotUpdateHashForNullGroup(){
  victim.updateHashForGroup("",null);
}
