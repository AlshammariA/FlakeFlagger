@Test public void should_fail_if_actual_does_not_contain_given_values_only(){
  AssertionInfo info=someInfo();
  actual=arrayOf(true);
  boolean[] expected={false};
  try {
    arrays.assertContainsOnly(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainOnly(actual,expected,newLinkedHashSet(false),newLinkedHashSet(true)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
