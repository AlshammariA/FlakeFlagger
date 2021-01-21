@Test public void should_fail_if_actual_contains_given_values(){
  AssertionInfo info=someInfo();
  float[] expected={6f,8f,20f};
  try {
    arrays.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet(6f,8f)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
