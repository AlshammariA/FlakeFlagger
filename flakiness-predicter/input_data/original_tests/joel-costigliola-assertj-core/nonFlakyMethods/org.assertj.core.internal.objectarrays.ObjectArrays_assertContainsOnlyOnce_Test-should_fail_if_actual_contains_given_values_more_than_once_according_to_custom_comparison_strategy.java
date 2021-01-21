@Test public void should_fail_if_actual_contains_given_values_more_than_once_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=array("Luke","yODA","Han","luke","yoda","Han","YodA");
  String[] expected={"Luke","yOda","Leia"};
  try {
    arraysWithCustomComparisonStrategy.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet("Leia"),newLinkedHashSet("Luke","yOda"),caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
