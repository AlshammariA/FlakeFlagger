@Test public void should_pass_if_actual_contains_given_values_exactly(){
  arrays.assertContainsExactly(someInfo(),actual,arrayOf('a','b','c'));
}
