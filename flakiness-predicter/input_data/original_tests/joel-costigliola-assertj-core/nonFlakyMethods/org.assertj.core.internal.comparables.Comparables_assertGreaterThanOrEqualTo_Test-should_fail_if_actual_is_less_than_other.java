@Test public void should_fail_if_actual_is_less_than_other(){
  AssertionInfo info=someInfo();
  try {
    comparables.assertGreaterThanOrEqualTo(info,6,8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreaterOrEqual(6,8));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
