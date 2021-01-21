@Test public void should_pass_if_actual_contains_sequence_according_to_custom_comparison_strategy(){
  stringsWithCaseInsensitiveComparisonStrategy.assertContainsSequence(someInfo(),"Yoda",array("Yo","da"));
  stringsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),"Yoda",array("Yo","DA"));
  stringsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),"Yoda",array("YO","dA"));
}
