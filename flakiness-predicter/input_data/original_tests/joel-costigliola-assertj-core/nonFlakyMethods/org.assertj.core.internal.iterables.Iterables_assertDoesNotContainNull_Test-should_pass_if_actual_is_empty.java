@Test public void should_pass_if_actual_is_empty(){
  actual=newArrayList();
  iterables.assertDoesNotContainNull(someInfo(),actual);
}
