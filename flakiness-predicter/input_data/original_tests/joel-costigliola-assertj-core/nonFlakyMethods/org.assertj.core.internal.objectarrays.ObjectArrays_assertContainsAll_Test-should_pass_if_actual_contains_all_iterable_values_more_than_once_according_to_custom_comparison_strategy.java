@Test public void should_pass_if_actual_contains_all_iterable_values_more_than_once_according_to_custom_comparison_strategy(){
  actual=array("Luke","Yoda","Leia","Luke","Luke");
  arraysWithCustomComparisonStrategy.assertContainsAll(someInfo(),actual,newArrayList("LUKE"));
}
