@Test public void should_pass_if_actual_contains_given_values_only_more_than_once(){
  actual=arrayOf('a','b','c','c','c');
  arrays.assertContainsOnly(someInfo(),actual,arrayOf('a','b','c'));
}
