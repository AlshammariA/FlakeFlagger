@Test public void should_fail_if_actual_does_not_contain_all_given_values(){
  AssertionInfo info=someInfo();
  String[] expected={"Luke","Yoda","Han"};
  try {
    arrays.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet("Han"),newLinkedHashSet()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
