@Test public void should_fail_if_actual_contains_all_given_values_but_in_different_order(){
  AssertionInfo info=someInfo();
  Object[] expected={"Luke","Leia","Yoda"};
  try {
    arrays.assertContainsExactly(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsDifferAtIndex("Yoda","Leia",1));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
