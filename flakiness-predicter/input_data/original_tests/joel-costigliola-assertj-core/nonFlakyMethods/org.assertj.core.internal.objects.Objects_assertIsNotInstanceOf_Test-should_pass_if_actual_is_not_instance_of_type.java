@Test public void should_pass_if_actual_is_not_instance_of_type(){
  objects.assertIsNotInstanceOf(someInfo(),actual,String.class);
}
