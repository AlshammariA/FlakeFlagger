@Test public void should_pass_if_actual_and_given_values_are_empty(){
  actual=emptyArray();
  arrays.assertEndsWith(someInfo(),actual,emptyArray());
}
