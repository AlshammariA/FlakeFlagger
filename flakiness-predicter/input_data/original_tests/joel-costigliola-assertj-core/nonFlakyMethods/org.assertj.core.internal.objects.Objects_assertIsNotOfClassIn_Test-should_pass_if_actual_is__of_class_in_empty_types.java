@Test public void should_pass_if_actual_is__of_class_in_empty_types(){
  Class<?>[] types=new Class[]{};
  objects.assertIsNotOfAnyClassIn(someInfo(),actual,types);
}
