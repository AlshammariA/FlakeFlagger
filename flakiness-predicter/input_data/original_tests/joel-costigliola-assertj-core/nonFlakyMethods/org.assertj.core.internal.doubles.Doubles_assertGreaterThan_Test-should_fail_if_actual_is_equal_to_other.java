@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    doubles.assertGreaterThan(info,6d,6d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(6d,6d));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
