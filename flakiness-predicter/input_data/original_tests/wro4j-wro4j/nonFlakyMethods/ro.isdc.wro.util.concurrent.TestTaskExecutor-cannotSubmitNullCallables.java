@Test(expected=NullPointerException.class) public void cannotSubmitNullCallables() throws Exception {
  final Collection<Callable<Void>> callables=null;
  victim.submit(callables);
}
