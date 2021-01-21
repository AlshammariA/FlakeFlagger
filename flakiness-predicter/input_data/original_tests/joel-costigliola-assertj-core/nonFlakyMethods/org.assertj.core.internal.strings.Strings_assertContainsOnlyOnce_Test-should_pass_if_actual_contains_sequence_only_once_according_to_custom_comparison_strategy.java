@Test public void should_pass_if_actual_contains_sequence_only_once_according_to_custom_comparison_strategy(){
  stringsWithCaseInsensitiveComparisonStrategy.assertContainsOnlyOnce(someInfo(),"Yoda","Yo");
  stringsWithCaseInsensitiveComparisonStrategy.assertContainsOnlyOnce(someInfo(),"Yoda","yo");
  stringsWithCaseInsensitiveComparisonStrategy.assertContainsOnlyOnce(someInfo(),"Yoda","YO");
}
