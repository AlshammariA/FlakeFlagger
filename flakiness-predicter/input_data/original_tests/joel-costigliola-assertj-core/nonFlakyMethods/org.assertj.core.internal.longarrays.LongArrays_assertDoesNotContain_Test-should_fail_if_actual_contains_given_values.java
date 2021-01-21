@Test public void should_fail_if_actual_contains_given_values(){
  AssertionInfo info=someInfo();
  long[] expected={6L,8L,20L};
  try {
    arrays.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet(6L,8L)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
