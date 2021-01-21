@Test public void should_pass_if_actual_has_one_element_of_the_expected_type(){
  arrays.assertHasAtLeastOneElementOfType(someInfo(),array,Integer.class);
  arrays.assertHasAtLeastOneElementOfType(someInfo(),array,String.class);
  arrays.assertHasAtLeastOneElementOfType(someInfo(),array,Object.class);
}
