@Test public void should_fail_if_actual_is_greater_than_other(){
  AssertionInfo info=someInfo();
  try {
    floats.assertLessThan(info,8f,6f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(8f,6f));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
