@Test public void should_fail_if_actual_contains_values_but_not_in_given_order_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  String[] sequenceValues={"{","author","A Game of Thrones","}"};
  String actual="{ 'title':'A Game of Thrones', 'author':'George Martin'}";
  try {
    stringsWithCaseInsensitiveComparisonStrategy.assertContainsSequence(info,actual,sequenceValues);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSequence(actual,sequenceValues,1,comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
