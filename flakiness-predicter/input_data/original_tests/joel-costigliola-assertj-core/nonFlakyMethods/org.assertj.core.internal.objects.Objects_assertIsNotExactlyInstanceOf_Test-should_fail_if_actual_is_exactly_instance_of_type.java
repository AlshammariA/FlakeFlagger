@Test public void should_fail_if_actual_is_exactly_instance_of_type(){
  AssertionInfo info=someInfo();
  try {
    objects.assertIsNotExactlyInstanceOf(info,"Yoda",String.class);
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldNotBeExactlyInstance("Yoda",String.class));
  }
}
