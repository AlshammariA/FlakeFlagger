@Test public void should_fail_if_array_is_not_null_and_is_not_empty(){
  AssertionInfo info=someInfo();
  boolean[] actual={true,false};
  try {
    arrays.assertNullOrEmpty(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeNullOrEmpty(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
