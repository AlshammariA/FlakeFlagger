@Test(expected=NullPointerException.class) public void cannotSetNullContext(){
  Context.set(null);
}
