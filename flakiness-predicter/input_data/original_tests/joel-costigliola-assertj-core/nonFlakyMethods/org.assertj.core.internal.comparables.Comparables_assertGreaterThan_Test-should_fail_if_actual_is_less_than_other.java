@Test public void should_fail_if_actual_is_less_than_other(){
  AssertionInfo info=someInfo();
  try {
    comparables.assertGreaterThan(info,6,8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(6,8));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
