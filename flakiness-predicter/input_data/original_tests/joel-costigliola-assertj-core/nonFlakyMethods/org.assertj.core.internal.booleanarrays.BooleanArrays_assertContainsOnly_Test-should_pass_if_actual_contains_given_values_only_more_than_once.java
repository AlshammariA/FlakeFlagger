@Test public void should_pass_if_actual_contains_given_values_only_more_than_once(){
  actual=arrayOf(true,false,true,false);
  arrays.assertContainsOnly(someInfo(),actual,arrayOf(true,false));
}
