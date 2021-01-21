@Test public void should_fail_if_actual_does_not_contain_given_values_only_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  char[] expected={'A','b','d'};
  try {
    arraysWithCustomComparisonStrategy.assertContainsOnly(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainOnly(actual,expected,newLinkedHashSet('d'),newLinkedHashSet('c'),caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
