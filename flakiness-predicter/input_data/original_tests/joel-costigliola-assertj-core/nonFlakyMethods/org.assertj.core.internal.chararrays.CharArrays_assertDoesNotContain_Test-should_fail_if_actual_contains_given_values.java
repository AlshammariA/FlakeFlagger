@Test public void should_fail_if_actual_contains_given_values(){
  AssertionInfo info=someInfo();
  char[] expected={'a','b','d'};
  try {
    arrays.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet('a','b')));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
