@Test public void should_fail_if_actual_is_not_of_class_in_types(){
  AssertionInfo info=someInfo();
  Class<?>[] types=new Class[]{File.class,String.class};
  try {
    objects.assertIsOfAnyClassIn(info,actual,types);
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldBeOfClassIn(actual,types));
  }
}
