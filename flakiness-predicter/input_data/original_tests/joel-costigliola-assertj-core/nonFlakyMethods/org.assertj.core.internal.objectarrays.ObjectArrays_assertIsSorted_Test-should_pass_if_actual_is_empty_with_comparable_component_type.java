@Test public void should_pass_if_actual_is_empty_with_comparable_component_type(){
  arrays.assertIsSorted(someInfo(),new String[0]);
}
