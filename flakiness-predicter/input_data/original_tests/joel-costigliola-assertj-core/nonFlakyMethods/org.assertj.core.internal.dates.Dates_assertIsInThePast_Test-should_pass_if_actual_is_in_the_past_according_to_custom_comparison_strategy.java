@Test public void should_pass_if_actual_is_in_the_past_according_to_custom_comparison_strategy(){
  actual=parseDate("2000-01-01");
  datesWithCustomComparisonStrategy.assertIsInThePast(someInfo(),actual);
}
