@Test public void should_pass_if_actual_is_not_of_class_in_types(){
  Class<?>[] types=new Class[]{File.class,String.class};
  objects.assertIsNotOfAnyClassIn(someInfo(),actual,types);
}
