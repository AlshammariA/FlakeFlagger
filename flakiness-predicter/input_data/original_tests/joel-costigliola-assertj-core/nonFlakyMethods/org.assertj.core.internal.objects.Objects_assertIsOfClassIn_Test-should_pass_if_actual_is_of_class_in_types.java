@Test public void should_pass_if_actual_is_of_class_in_types(){
  Class<?>[] types=new Class[]{File.class,Person.class,String.class};
  objects.assertIsOfAnyClassIn(someInfo(),actual,types);
}
