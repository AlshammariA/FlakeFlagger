@Test public void should_pass_if_actual_is_subset_of_values_according_to_custom_comparison_strategy(){
  actual=array("Yoda","Luke");
  arraysWithCustomComparisonStrategy.assertIsSubsetOf(someInfo(),actual,newArrayList("yoda","lUKE"));
}
