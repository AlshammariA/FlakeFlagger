@Test public void should_pass_if_actual_is_not_instance_of_any_type(){
  Class<?>[] types={String.class,File.class};
  objects.assertIsNotInstanceOfAny(someInfo(),actual,types);
}
