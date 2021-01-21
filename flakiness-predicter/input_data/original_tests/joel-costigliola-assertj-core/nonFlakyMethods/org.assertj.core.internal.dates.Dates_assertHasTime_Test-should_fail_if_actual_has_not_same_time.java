@Test() public void should_fail_if_actual_has_not_same_time(){
  AssertionInfo info=someInfo();
  try {
    dates.assertHasTime(someInfo(),actual,24L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveTime(actual,24L));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
