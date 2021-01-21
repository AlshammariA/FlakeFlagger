@Test public void should_fail_if_actual_contains_given_values_more_than_once_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual.addAll(newArrayList("Luke","Luke"));
  Object[] expected=array("luke","YOda","LeIA");
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertContainsOnlyOnce(someInfo(),actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet(),newLinkedHashSet("luke"),comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
