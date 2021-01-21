@Test public void should_pass_if_actual_ends_with_suffix_according_to_custom_comparison_strategy(){
  stringsWithCaseInsensitiveComparisonStrategy.assertEndsWith(someInfo(),"Yoda","oda");
  stringsWithCaseInsensitiveComparisonStrategy.assertEndsWith(someInfo(),"Yoda","da");
  stringsWithCaseInsensitiveComparisonStrategy.assertEndsWith(someInfo(),"Yoda","a");
  stringsWithCaseInsensitiveComparisonStrategy.assertEndsWith(someInfo(),"Yoda","Oda");
  stringsWithCaseInsensitiveComparisonStrategy.assertEndsWith(someInfo(),"Yoda","ODA");
}
