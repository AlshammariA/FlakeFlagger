@Test(expected=NullPointerException.class) public void cannotAcceptNullArgument() throws Exception {
  new ObjectPoolHelper<Void>(null);
}
