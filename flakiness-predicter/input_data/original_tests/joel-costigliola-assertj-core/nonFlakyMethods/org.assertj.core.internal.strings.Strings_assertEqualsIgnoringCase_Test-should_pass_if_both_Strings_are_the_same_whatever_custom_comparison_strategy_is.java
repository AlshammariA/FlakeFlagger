@Test public void should_pass_if_both_Strings_are_the_same_whatever_custom_comparison_strategy_is(){
  String s="Yoda";
  stringsWithCaseInsensitiveComparisonStrategy.assertEqualsIgnoringCase(someInfo(),s,s);
}
