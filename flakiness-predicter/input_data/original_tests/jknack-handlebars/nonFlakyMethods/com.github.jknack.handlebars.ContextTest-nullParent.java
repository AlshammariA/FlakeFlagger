@Test(expected=NullPointerException.class) public void nullParent(){
  Context.newContext(null,new Object());
}
