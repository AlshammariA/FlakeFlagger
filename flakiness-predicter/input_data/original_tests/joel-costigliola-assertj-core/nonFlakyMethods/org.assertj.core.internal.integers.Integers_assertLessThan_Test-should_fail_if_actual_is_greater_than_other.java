@Test public void should_fail_if_actual_is_greater_than_other(){
  AssertionInfo info=someInfo();
  try {
    integers.assertLessThan(info,8,6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(8,6));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
