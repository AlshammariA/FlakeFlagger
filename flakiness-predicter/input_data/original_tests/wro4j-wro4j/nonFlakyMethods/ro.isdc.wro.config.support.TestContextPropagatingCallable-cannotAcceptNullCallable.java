@Test(expected=NullPointerException.class) public void cannotAcceptNullCallable(){
  new ContextPropagatingCallable<Void>(null);
}
