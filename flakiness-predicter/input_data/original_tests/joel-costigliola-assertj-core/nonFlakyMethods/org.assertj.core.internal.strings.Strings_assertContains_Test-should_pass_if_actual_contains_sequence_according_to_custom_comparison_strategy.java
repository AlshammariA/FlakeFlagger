@Test public void should_pass_if_actual_contains_sequence_according_to_custom_comparison_strategy(){
  stringsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),"Yoda","Yo");
  stringsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),"Yoda","yo");
  stringsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),"Yoda","YO");
}
