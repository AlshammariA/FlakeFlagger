@Test public void should_pass_if_objects_are_not_equal_according_to_custom_comparison_strategy(){
  objectsWithCustomComparisonStrategy.assertNotEqual(someInfo(),"Yoda","Luke");
}
