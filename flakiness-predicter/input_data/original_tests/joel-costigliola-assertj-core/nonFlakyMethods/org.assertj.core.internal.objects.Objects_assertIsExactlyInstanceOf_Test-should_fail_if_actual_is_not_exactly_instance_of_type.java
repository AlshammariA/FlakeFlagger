@Test public void should_fail_if_actual_is_not_exactly_instance_of_type(){
  AssertionInfo info=someInfo();
  try {
    objects.assertIsExactlyInstanceOf(info,"Yoda",Object.class);
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldBeExactlyInstance("Yoda",Object.class));
  }
}
