@Test public void should_pass_if_actual_and_given_values_are_empty(){
  actual=new String[0];
  arrays.assertStartsWith(someInfo(),actual,emptyArray());
}
