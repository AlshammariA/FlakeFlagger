@Test public void should_pass_if_actual_does_not_contain_sequence_according_to_custom_comparison_strategy(){
  stringsWithCaseInsensitiveComparisonStrategy.assertDoesNotContain(someInfo(),"Yoda","Lu");
}
