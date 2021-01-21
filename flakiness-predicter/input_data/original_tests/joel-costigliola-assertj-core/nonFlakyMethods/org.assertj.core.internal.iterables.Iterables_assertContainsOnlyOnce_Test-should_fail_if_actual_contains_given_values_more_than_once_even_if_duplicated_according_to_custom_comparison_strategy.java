@Test public void should_fail_if_actual_contains_given_values_more_than_once_even_if_duplicated_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual.addAll(newArrayList("LUKE"));
  Object[] expected=array("LUke","LUke","lukE","YOda","Leia","Han");
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertContainsOnlyOnce(someInfo(),actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet("Han"),newLinkedHashSet("LUke","lukE"),comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
