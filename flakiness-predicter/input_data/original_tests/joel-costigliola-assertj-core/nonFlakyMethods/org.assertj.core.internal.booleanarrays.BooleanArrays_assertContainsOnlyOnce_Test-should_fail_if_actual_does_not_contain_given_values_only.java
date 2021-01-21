@Test public void should_fail_if_actual_does_not_contain_given_values_only(){
  AssertionInfo info=someInfo();
  actual=arrayOf(true);
  boolean[] expected={true,false};
  try {
    arrays.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet(false),newLinkedHashSet()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
