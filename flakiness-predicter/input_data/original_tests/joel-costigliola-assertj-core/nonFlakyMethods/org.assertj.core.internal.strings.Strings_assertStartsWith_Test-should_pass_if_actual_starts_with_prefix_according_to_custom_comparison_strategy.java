@Test public void should_pass_if_actual_starts_with_prefix_according_to_custom_comparison_strategy(){
  stringsWithCaseInsensitiveComparisonStrategy.assertStartsWith(someInfo(),"Yoda","Y");
  stringsWithCaseInsensitiveComparisonStrategy.assertStartsWith(someInfo(),"Yoda","Yo");
  stringsWithCaseInsensitiveComparisonStrategy.assertStartsWith(someInfo(),"Yoda","Yod");
  stringsWithCaseInsensitiveComparisonStrategy.assertStartsWith(someInfo(),"Yoda","Yoda");
  stringsWithCaseInsensitiveComparisonStrategy.assertStartsWith(someInfo(),"Yoda","yoda");
  stringsWithCaseInsensitiveComparisonStrategy.assertStartsWith(someInfo(),"Yoda","YODA");
}
