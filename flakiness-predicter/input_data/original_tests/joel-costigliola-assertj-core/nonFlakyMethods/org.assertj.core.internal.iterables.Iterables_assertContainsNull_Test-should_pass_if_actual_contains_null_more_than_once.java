@Test public void should_pass_if_actual_contains_null_more_than_once(){
  actual.add(null);
  iterables.assertContainsNull(someInfo(),actual);
}
