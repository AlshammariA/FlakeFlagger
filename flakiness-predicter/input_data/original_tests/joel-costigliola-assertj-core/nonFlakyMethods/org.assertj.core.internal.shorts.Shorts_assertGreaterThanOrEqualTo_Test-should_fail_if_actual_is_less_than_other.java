@Test public void should_fail_if_actual_is_less_than_other(){
  AssertionInfo info=someInfo();
  try {
    shorts.assertGreaterThanOrEqualTo(info,(short)6,(short)8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreaterOrEqual((short)6,(short)8));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
