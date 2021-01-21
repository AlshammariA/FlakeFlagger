@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    floats.assertGreaterThan(info,6f,6f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(6f,6f));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
