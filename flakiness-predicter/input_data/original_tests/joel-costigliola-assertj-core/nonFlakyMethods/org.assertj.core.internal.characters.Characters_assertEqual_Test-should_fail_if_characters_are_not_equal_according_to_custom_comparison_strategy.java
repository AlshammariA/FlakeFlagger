@Test public void should_fail_if_characters_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertEqual(info,'b','a');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual('b','a',caseInsensitiveComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
