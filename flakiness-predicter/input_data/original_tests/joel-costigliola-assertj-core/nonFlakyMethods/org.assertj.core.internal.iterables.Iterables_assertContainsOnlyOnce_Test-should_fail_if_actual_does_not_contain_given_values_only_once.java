@Test public void should_fail_if_actual_does_not_contain_given_values_only_once(){
  AssertionInfo info=someInfo();
  Object[] expected={"Luke","Yoda","Han"};
  try {
    iterables.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet("Han"),newLinkedHashSet()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
