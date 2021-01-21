@Test public void should_fail_if_actual_contains_given_values(){
  AssertionInfo info=someInfo();
  boolean[] expected=arrayOf(true);
  try {
    arrays.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet(true)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
