@Test public void should_fail_if_characters_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertEqual(info,'b','a');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual('b','a',info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
