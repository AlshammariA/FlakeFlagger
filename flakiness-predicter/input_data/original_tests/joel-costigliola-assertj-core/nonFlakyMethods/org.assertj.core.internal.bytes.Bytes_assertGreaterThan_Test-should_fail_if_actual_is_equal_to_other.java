@Test public void should_fail_if_actual_is_equal_to_other(){
  try {
    bytes.assertGreaterThan(someInfo(),(byte)6,(byte)6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(someInfo(),shouldBeGreater((byte)6,(byte)6));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
