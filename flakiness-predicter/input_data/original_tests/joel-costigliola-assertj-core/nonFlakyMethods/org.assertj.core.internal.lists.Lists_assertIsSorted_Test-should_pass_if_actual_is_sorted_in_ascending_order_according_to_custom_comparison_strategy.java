@Test public void should_pass_if_actual_is_sorted_in_ascending_order_according_to_custom_comparison_strategy(){
  actual=newArrayList("leia","LUKE","luke","Vador","Yoda");
  listsWithCaseInsensitiveComparisonStrategy.assertIsSorted(someInfo(),actual);
}
