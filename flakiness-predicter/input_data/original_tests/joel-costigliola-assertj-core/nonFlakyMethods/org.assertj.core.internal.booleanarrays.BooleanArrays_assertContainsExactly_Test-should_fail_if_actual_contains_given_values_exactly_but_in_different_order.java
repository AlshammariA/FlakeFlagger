@Test public void should_fail_if_actual_contains_given_values_exactly_but_in_different_order(){
  AssertionInfo info=someInfo();
  try {
    arrays.assertContainsExactly(info,actual,arrayOf(false,true));
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsDifferAtIndex(true,false,0));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
