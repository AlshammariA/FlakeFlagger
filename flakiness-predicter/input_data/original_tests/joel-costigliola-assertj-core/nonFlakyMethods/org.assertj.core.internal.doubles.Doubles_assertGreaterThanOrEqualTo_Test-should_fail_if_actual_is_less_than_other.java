@Test public void should_fail_if_actual_is_less_than_other(){
  AssertionInfo info=someInfo();
  try {
    doubles.assertGreaterThanOrEqualTo(info,6d,8d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreaterOrEqual(6d,8d));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
