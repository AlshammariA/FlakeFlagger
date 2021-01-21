@Test public void should_fail_if_actual_is_not_instance_of_type(){
  AssertionInfo info=someInfo();
  try {
    objects.assertIsInstanceOf(info,actual,String.class);
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldBeInstance(actual,String.class));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
