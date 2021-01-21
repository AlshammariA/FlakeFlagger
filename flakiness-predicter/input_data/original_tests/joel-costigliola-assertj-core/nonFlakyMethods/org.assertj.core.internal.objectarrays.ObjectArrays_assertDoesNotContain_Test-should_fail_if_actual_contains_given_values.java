@Test public void should_fail_if_actual_contains_given_values(){
  AssertionInfo info=someInfo();
  Object[] expected={"Luke","Yoda","Han"};
  try {
    arrays.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet("Luke","Yoda")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
