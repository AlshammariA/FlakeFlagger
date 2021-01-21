@Test public void should_fail_if_characters_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertNotEqual(info,'b','B');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual('b','B',caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
