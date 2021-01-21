@Test public void should_pass_if_objects_are_not_equal_whatever_custom_comparison_strategy_is(){
  Person actual=spy(new Person("YODA"));
  Person other=new Person("Yoda");
  comparablesWithCustomComparisonStrategy.assertNotEqualByComparison(someInfo(),actual,other);
  verify(actual).compareTo(other);
}
