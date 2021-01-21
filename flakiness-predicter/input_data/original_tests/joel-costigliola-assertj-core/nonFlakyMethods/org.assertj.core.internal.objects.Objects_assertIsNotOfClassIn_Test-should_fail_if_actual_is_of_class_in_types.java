@Test public void should_fail_if_actual_is_of_class_in_types(){
  AssertionInfo info=someInfo();
  Class<?>[] types=new Class[]{File.class,Person.class,String.class};
  try {
    objects.assertIsNotOfAnyClassIn(info,actual,types);
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldNotBeOfClassIn(actual,types));
  }
}
