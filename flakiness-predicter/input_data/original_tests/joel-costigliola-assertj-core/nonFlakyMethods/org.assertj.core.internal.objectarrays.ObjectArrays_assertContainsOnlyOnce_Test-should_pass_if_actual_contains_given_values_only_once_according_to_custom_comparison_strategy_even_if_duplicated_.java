@Test public void should_pass_if_actual_contains_given_values_only_once_according_to_custom_comparison_strategy_even_if_duplicated_(){
  arraysWithCustomComparisonStrategy.assertContainsOnlyOnce(someInfo(),actual,array("Luke","Yoda","Leia","Luke","yODA","LeiA"));
}
