@Test public void should_fail_if_actual_is_null_according_to_custom_comparison_strategy(){
  thrown.expectAssertionError(actualIsNull());
  charactersWithCaseInsensitiveComparisonStrategy.assertEqual(someInfo(),null,'a');
}
