@Test public void should_pass_if_actual_contains_given_values_exactly(){
  arrays.assertContainsExactly(someInfo(),actual,arrayOf(6L,8L,10L));
}
