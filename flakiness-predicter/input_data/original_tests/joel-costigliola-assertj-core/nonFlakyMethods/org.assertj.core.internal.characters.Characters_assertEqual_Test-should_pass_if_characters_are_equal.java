@Test public void should_pass_if_characters_are_equal(){
  charactersWithCaseInsensitiveComparisonStrategy.assertEqual(someInfo(),'a','a');
}
