@Test public void should_pass_if_characters_are_equal_according_to_custom_comparison_strategy(){
  charactersWithCaseInsensitiveComparisonStrategy.assertEqual(someInfo(),'a','A');
}
