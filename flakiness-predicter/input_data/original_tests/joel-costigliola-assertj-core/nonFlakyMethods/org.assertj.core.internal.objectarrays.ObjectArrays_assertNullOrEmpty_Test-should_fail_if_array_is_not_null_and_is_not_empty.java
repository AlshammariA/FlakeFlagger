@Test public void should_fail_if_array_is_not_null_and_is_not_empty(){
  AssertionInfo info=someInfo();
  Integer[] actual=new Integer[]{5,8};
  try {
    arrays.assertNullOrEmpty(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeNullOrEmpty(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
