@Test public void should_pass_if_actual_does_not_contain_given_values_even_if_duplicated(){
  arrays.assertDoesNotContain(someInfo(),actual,arrayOf(false,false));
}
