@Test public void should_fail_if_actual_does_not_contain_given_values_exactly(){
  AssertionInfo info=someInfo();
  char[] expected={'a','b','e'};
  try {
    arrays.assertContainsExactly(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainExactly(actual,expected,newLinkedHashSet('e'),newLinkedHashSet('c')));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
