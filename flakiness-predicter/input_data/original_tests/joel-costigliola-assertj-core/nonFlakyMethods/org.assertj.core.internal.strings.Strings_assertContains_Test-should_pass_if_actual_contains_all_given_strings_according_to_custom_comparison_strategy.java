@Test public void should_pass_if_actual_contains_all_given_strings_according_to_custom_comparison_strategy(){
  stringsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),"Yoda","YO","dA");
}
