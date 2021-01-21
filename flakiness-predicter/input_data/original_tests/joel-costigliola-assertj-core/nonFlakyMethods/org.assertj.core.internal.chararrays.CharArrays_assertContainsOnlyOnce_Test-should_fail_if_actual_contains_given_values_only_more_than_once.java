@Test public void should_fail_if_actual_contains_given_values_only_more_than_once(){
  AssertionInfo info=someInfo();
  actual=arrayOf('a','b','b','a','c','d');
  char[] expected={'a','b','e'};
  try {
    arrays.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet('e'),newLinkedHashSet('a','b')));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
