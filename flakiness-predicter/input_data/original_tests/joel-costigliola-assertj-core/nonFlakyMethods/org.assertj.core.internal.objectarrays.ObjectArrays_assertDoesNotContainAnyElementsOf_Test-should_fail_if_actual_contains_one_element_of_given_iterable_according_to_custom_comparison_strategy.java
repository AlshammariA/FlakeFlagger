@Test public void should_fail_if_actual_contains_one_element_of_given_iterable_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  List<String> expected=newArrayList("LuKe","YODA","Han");
  try {
    arraysWithCustomComparisonStrategy.assertDoesNotContainAnyElementsOf(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected.toArray(),newLinkedHashSet("LuKe","YODA"),caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
