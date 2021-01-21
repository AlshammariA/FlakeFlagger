@Test(expected=WroRuntimeException.class) public void shouldFailWhenNoContextIsAvailable(){
  Context.unset();
  new ContextPropagatingCallable<Void>(NO_OP_CALLABLE);
}
