@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    shorts.assertGreaterThan(info,(short)6,(short)6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater((short)6,(short)6));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
