@Test public void should_pass_if_both_Strings_are_equal_but_not_same_whatever_custom_comparison_strategy_is(){
  stringsWithCaseInsensitiveComparisonStrategy.assertEqualsIgnoringCase(someInfo(),"Yoda",new String(arrayOf('Y','o','d','a')));
}
