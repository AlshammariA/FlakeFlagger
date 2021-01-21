@Test public void should_fail_if_actual_contains_given_values_only_more_than_once(){
  AssertionInfo info=someInfo();
  actual=arrayOf(true,true,false,false);
  boolean[] expected={true,false};
  try {
    arrays.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet(),newLinkedHashSet(true,false)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
