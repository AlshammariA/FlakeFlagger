@Test(expected=NullPointerException.class) public void cannotSetObjectForNullAttribute(){
  victim.setAttribute(null,null);
}
