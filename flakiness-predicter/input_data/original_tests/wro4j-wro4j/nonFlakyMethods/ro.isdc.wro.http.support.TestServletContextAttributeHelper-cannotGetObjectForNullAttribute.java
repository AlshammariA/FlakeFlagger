@Test(expected=NullPointerException.class) public void cannotGetObjectForNullAttribute(){
  victim.getAttribute(null);
}
