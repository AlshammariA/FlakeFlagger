@Test public void should_pass_if_actual_and_sequence_are_equal_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertEndsWith(someInfo(),actual,array("YOda","LUke","Leia","OBI-Wan"));
}
