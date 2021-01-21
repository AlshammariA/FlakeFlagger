@Test public void should_fail_if_actual_contains_given_values_exactly_but_in_different_order(){
  AssertionInfo info=someInfo();
  try {
    arrays.assertContainsExactly(info,actual,arrayOf(6,10,8));
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsDifferAtIndex(8,10,1));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
