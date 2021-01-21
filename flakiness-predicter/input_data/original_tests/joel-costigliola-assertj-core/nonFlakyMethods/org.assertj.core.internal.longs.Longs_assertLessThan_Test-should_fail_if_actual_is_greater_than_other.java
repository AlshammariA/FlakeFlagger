@Test public void should_fail_if_actual_is_greater_than_other(){
  AssertionInfo info=someInfo();
  try {
    longs.assertLessThan(info,8L,6L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(8L,6L));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
