@Test public void should_pass_if_actual_is_exactly_instance_of_type(){
  objects.assertIsExactlyInstanceOf(someInfo(),"Yoda",String.class);
}
