@Test public void should_pass_if_lines_count_of_actual_is_equal_to_expected_lines_count_whatever_custom_comparison_strategy_is(){
  stringsWithCaseInsensitiveComparisonStrategy.assertHasLineCount(someInfo(),"Begin" + LINE_SEPARATOR + "End",2);
}
