@Test public void should_pass_if_actual_is_null(){
  iterables.assertNullOrEmpty(someInfo(),null);
}
