@Test public void should_pass_if_actual_and_sequence_are_equal_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertStartsWith(someInfo(),actual,array("Yoda","LUke","LeIA","oBi-WaN"));
}
