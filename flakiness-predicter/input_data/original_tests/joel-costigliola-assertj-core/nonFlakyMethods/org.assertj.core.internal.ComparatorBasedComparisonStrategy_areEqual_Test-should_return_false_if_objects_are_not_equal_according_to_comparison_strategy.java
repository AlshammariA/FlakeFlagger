@Test public void should_return_false_if_objects_are_not_equal_according_to_comparison_strategy(){
  assertFalse(caseInsensitiveComparisonStrategy.areEqual("Yoda","Yod"));
}
