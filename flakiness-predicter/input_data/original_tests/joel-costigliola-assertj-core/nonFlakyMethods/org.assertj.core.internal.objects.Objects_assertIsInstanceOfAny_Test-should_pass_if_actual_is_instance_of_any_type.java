@Test public void should_pass_if_actual_is_instance_of_any_type(){
  Class<?>[] types={String.class,Person.class};
  objects.assertIsInstanceOfAny(someInfo(),actual,types);
}
