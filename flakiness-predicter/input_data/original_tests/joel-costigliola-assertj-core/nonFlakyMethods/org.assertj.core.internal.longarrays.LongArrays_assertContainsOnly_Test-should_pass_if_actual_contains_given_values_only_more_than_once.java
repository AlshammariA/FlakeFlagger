@Test public void should_pass_if_actual_contains_given_values_only_more_than_once(){
  actual=arrayOf(6L,8L,10L,8L,8L,8L);
  arrays.assertContainsOnly(someInfo(),actual,arrayOf(6L,8L,10L));
}
