@Test public void should_fail_if_array_of_values_to_look_for_is_empty_and_actual_is_not(){
  thrown.expect(AssertionError.class);
  arrays.assertStartsWith(someInfo(),actual,emptyArray());
}
