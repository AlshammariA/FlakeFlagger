@Test public void should_pass_if_actual_contains_duplicates_according_to_custom_comparison_strategy(){
  actual=array("Luke","Luke");
  arraysWithCustomComparisonStrategy.assertIsSubsetOf(someInfo(),actual,newArrayList("LUke","yoda"));
}
