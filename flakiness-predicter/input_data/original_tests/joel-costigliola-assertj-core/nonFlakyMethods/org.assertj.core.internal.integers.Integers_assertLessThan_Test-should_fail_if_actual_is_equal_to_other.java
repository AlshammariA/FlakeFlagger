@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    integers.assertLessThan(info,6,6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(6,6));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
