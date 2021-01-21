@Test public void should_fail_if_actual_is_less_than_other(){
  AssertionInfo info=someInfo();
  try {
    floats.assertGreaterThanOrEqualTo(info,6f,8f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreaterOrEqual(6f,8f));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
