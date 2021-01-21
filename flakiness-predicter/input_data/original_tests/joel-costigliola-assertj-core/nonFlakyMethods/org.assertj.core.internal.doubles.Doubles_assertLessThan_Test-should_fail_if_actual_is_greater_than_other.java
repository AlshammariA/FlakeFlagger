@Test public void should_fail_if_actual_is_greater_than_other(){
  AssertionInfo info=someInfo();
  try {
    doubles.assertLessThan(info,8d,6d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(8d,6d));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
