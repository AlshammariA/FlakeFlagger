@Test public void should_fail_if_actual_contains_given_values_exactly_but_in_different_order(){
  AssertionInfo info=someInfo();
  try {
    arrays.assertContainsExactly(info,actual,arrayOf(6f,10f,8f));
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsDifferAtIndex(8f,10f,1));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
