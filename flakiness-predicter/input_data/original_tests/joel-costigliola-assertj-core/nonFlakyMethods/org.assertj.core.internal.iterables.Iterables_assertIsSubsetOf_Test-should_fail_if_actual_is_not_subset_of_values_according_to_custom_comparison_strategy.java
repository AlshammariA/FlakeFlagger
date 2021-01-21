@Test public void should_fail_if_actual_is_not_subset_of_values_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=newArrayList("Yoda","Luke");
  List<String> values=newArrayList("yoda","C-3PO");
  List<String> extra=newArrayList("Luke");
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertIsSubsetOf(info,actual,values);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSubsetOf(actual,values,extra,comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
